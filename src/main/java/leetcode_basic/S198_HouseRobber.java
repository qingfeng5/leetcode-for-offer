package leetcode_basic;

import java.util.Arrays;

/**
 * Created by 清风
 * 2020/5/19 11:27
 * /// 198. House Robber
 * /// https://leetcode.com/problems/house-robber/description/
 * /// 记忆化搜索
 * /// 时间复杂度: O(n^2)
 * /// 空间复杂度: O(n)
 *
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号 房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * z注意其中对状态的定义：
 * 考虑偷取[x...n-1]范围里的放子，（函数定义）
 *
 * 根据对状态的定义，决定状态的转移：
 * f（0） =max{ v(0)+ f(2),v(1)+v(2) , v(2)+v(4),,,
 *                  v(n-3)+f(n-1) ,v(n-2),v(n-1) }    (状态转移方程)
 */
public class S198_HouseRobber {
    // memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
    //出现重叠项
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    private int tryRob(int[] nums, int index){

        if(index >= nums.length)
            return 0;

        //memo是否有值，如果有值，就是直接将memo[index]，返回回去,不需要进行下面的计算了
        if(memo[index] != -1)
            return memo[index];

        int res = 0;
        for(int i = index ; i < nums.length ; i ++)
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        memo[index] = res;
        return res;
    }

    public static void main(String[] args) {

        int nums[] = {2, 1};
        System.out.println((new S198_HouseRobber()).rob(nums));
    }
}
