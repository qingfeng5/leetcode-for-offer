package leetcode;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/7/16 21:33
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class S46_translateNum_02 {
    //为方便获取数字的各位 x_i
    //  ，考虑先将数字 numnum 转化为字符串 s ，通过遍历 s 实现动态规划。
    //通过字符串切片 s[i - 2:i]s[i−2:i] 获取数字组合 10 x_{i-1} + x_i10x
    //i−1
    // +x
    //通过对比字符串 ASCII 码判断字符串对应的数字区间。
    //空间使用优化： 由于 dp[i] 只与 dp[i - 1] 有关，
    // 因此可使用两个变量 a, ba,b 分别记录 dp[i], dp[i - 1]，
    // 两变量交替前进即可。此方法可省去 dpdp 列表使用的 O(N)O(N) 的额外空间。
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }

}
