package leetcode_class.T03_dp;

/**
 * Created by 清风
 * 2020/9/27 15:31
 * 面试题 17.09. 第 k 个数
 * 有些数的素因子只有 3，5，7，
 * 请设计一个算法找出第 k 个数。
 * 注意，不是必须有这些素因子，而是必须不包含其他的素因子。
 * 例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * 示例 1:
 *
 * 输入: k = 5
 *
 * 输出: 9
 */
public class SL_17_09_getKthMagicNumber {
    public int getKthMagicNumber(int k) {
        //定义三个指针p3,p5,p7，
        // p3指向的数字永远乘3，p5指向的数字永远乘5，p7指向的数字永远乘7
        int p3=0,p5=0,p7=0;

        int[] dp=new int[k];
        //初始化所有指针都指向第一个丑数，即1
        dp[0]=1;
        //dp[p3]*3,dp[p5]*5,dp[p7]*7选取最小的一个数字，作为新的丑数。
        // 这边新的丑数就是3*dp[p3]=3*1=3，然后p3++
        for(int i=1;i<k;i++){
            dp[i]=Math.min(dp[p3]*3,Math.min(dp[p5]*5,dp[p7]*7));
            if(dp[i]==dp[p3]*3) p3++;
            //此时p5和p7指向第1个丑数，p3指向第2个丑数。然后重复上一步
            if(dp[i]==dp[p5]*5) p5++;
            if(dp[i]==dp[p7]*7) p7++;
        }
        return dp[k-1];

    }
}
