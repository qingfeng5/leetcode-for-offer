package leetcode_basic;

/// 198. House Robber
/// https://leetcode.com/problems/house-robber/description/
/// 动态规划
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)
public class S198_houseRobber_dyna {

    public int rob(int[] nums) {

        int n = nums.length;
        //数组就直接返回0即可
        if(n == 0)
            return 0;

        // memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
        int[] memo = new int[nums.length];
        //n-1防止数组越界问题，n=0就会越界
        memo[n - 1] = nums[n - 1];
        //最后到i=0，就是memo[0]就是整个整体，通过规模较小的问题，一步一步的得出规模较大的问题
        for(int i = n - 2 ; i >= 0 ; i --)
            //状态转移方程，每一次都是在求解memo【i】
            for (int j = i; j < n; j++)
                //看最大值，看原来的值，以及新的策略
                //新的策略，就是memo[j]索引对应的房子，在加上memo[j+2]，一直考虑j+2到n-1这些房子中要偷取谁
                //但是j+2可能越界，j+2要小于n的，
                // 写出一个判断，小于memo[j+2] ,否则就是没有元素了，就是0
                memo[i] = Math.max( memo[i],
                                    nums[j] + (j + 2 < n ? memo[j + 2] : 0));
        return memo[0];
    }

    public static void main(String[] args) {

        int nums[] = {2, 1};
        System.out.println((new S198_houseRobber_dyna()).rob(nums));
    }
}
