package niuke;

/// 背包问题
/// 记忆化搜索
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(n * C)
public class S00_knapsack0_1 {

    private int[][] memo;

    public int knapsack01(int[] w, int[] v, int C){

        if(w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v");

        if(C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;
        if(n == 0 || C == 0)
            return 0;

        //初始化容量
        memo = new int[n][C + 1];
        return bestValue(w, v, n - 1, C);
    }

    // 用 [0...index]的物品,填充容积为c的背包的最大价值
    private int bestValue(int[] w, int[] v, int index, int c){

        //如果这个index小于0了，就是0到-1或者-2，这个集合都是空集了，选不出任何物品
        //或者这个背包的容量c小于0了，装不进任何物品
        if(c <= 0 || index < 0)
            return 0;

        //是否被记录过
        if(memo[index][c] != -1)
            return memo[index][c];

        //否则就在背包中放入新的物品
        //放入物品考虑这个集合中的最后一个物品，index这个物品该不该放进去
        //一个策略是对于这个物品我根本不去管
        //这个里面物品不考虑，直接考虑index-1 ，index-1的物品在填充容积为c的背包，他所能得到的最大价值
        int res = bestValue(w, v, index-1, c);

        //另外一种方式，将第index商品放进背包里
        //先判断背包容积c大于，第index的物品
        if(c >= w[index])
            //这样尝试将index放进背包的话
            //此时背包的价值就是v【index】 + bestValue（）
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));

        return memo[index][c] = res;
    }

    public static void main(String[] args) {

    }

}
