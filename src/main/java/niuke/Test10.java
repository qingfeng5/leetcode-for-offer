package niuke;

import java.util.Scanner;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/8/8 16:29
 */
public class Test10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 总价格
        int t = input.nextInt();
        // 物品总数
        int n = input.nextInt();
        // 每个物品的价值
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = input.nextInt();
        }

        // 预算为 t 时的最小价值
        int[] dp = new int[t + 1];

        for (int i = 0; i < n; i++) {
            for (int j = values[i]; j < t + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j]- values[i]);
            }
        }
        // 输出结果
        System.out.println(dp[t]);
    }
}
