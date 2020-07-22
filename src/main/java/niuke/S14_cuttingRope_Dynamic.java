package niuke;

/// 343. Integer Break
/// https://leetcode.com/problems/integer-break/description/
/// 动态规划
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)

/** 面试题13. 机器人的运动范围
        * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
        * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
        * 也不能进入行坐标和列坐标的数位之和大于k的格子。
        * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
        * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
        *
        * 示例 1：
        * 输入：m = 2, n = 3, k = 1
        * 输出：3
        *
        *  示例 2：
        * 输入：m = 3, n = 1, k = 0
        * 输出：1
 * * 当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *  *
 *  * 示例 1：
 *  * 输入: 2
 *  * 输出: 1
 *  * 解释: 2 = 1 + 1, 1 × 1 = 1
 *  *
 *  * 示例 2:
 *  * 输入: 10
 *  * 输出: 36
 *  * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *  *

 **/
public class S14_cuttingRope_Dynamic {

    public int integerBreak(int n) {

        if(n < 1)
            throw new IllegalArgumentException("n should be greater than zero");

        //memo[i]表示将数字i分割（至少分割成两部分）后得到最大的乘机
        int[] memo = new int[n+1];
        memo[1] = 1;
        for(int i = 2 ; i <= n ; i ++)
            // 求解memo[i]
            //下面循环，对i这个数字进行分割
            //每一个都将 i 这个数字分割成 j+（i-j）
            for(int j = 1 ; j <= i - 1 ; j ++)
                //分割成两部分， j * （i-j）和 j* memo[i-j]
                //因为i-j一定小于i，此时的memo[i-j]一定已经计算出来了，这里就可以被使用
                //将这两个备选项循环求出最大值，放进memo[i]中，在继续取最大值
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);

        return memo[n];
    }

    private int max3(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {

        System.out.println((new S14_cuttingRope_Dynamic()).integerBreak(2));
        System.out.println((new S14_cuttingRope_Dynamic()).integerBreak(10));
    }
}
