package niuke;

import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/2 12:37
 * 奇安信
 * 价格 t，价格p ，价值w
 * 100，
 * 5
 * 77，92
 * 33，22
 * 29，36
 * 50，46
 * 99，22
 * 输出114
 *
 * 背包问题0-1
 */
public class S01_Value0_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 总预算
        int t = input.nextInt();
        // 物资总数
        int n = input.nextInt();
        // 每个物品的价格
        int[] prices = new int[n];
        // 每个物品的价值
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = input.nextInt();
            values[i] = input.nextInt();
        }

        // 预算为 t 时的最大价值
        int[] dp = new int[t + 1];

        for (int i = 0; i < n; i++) {
            for (int j = prices[i]; j < t + 1; j++) {
                dp[j] = Math.max(dp[j], dp[j - prices[i]] + values[i]);
            }
        }

        // 输出结果
        System.out.println(dp[t]);
    }
}
