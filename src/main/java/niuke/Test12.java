package niuke;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/8/20 19:52
 */
public class Test12 {
    /**
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int maxSumDivFive (int[] nums) {
        // write code here
        int[] dp = new int[]{0,0,0,0,0};

        for (int i = 0; i < nums.length; i++) {
            int k = nums[i] % 5;

            int a = dp[(5 + 0 -k) % 5];
            int b = dp[(5 + 1 -k) % 5];
            int c = dp[(5 + 0 -k) % 5];

            if (a!= 0 || k == 0){
                dp[0]= Math.max(dp[0],a+nums[i]);
            }
            if (b!= 0 || k == 1){
                dp[0]= Math.max(dp[1],a+nums[i]);
            }
            if (c!= 0 || k == 2){
                dp[0]= Math.max(dp[2],a+nums[i]);
            }
        }
        return dp[0];
    }
}
