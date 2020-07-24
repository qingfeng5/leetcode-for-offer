package leetcode;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/7/23 22:21
 *
 * 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class S63_maxProfit {
    //动态规划解析：
    //状态定义： 设动态规划列表 dp ，
    // dp[i] 代表以 prices[i] 为结尾的子数组的最大利润（以下简称为 前 i 日的最大利润 ）。
    //转移方程： 由于题目限定 “买卖该股票一次” ，
    // 因此前 i 日最大利润 dp[i] 等于前 i - 1 日最大利润 dp[i-1] 和第 i 日卖出的最大利润中的最大值。
    //前 i 日最大利润 = \max(前 (i-1) 日最大利润, 第 i 日价格 - 前 i 日最低价格)
    //前i日最大利润=max(前(i−1)日最大利润,第i日价格−前i日最低价格)
    //
    //dp[i] = \max(dp[i - 1], prices[i] - \min(prices[0:i]))
    //dp[i]=max(dp[i−1],prices[i]−min(prices[0:i]))
    //
    //初始状态： dp[0] = 0 ，即首日利润为 00 ；
    //返回值： dp[n - 1]dp[n−1] ，其中 nn 为 dpdp 列表长度。
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
