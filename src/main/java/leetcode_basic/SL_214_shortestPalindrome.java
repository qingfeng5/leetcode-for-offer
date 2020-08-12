package leetcode_basic;

/**
 * Created by 清风
 * 2020/8/12 19:52
 * 困难
 * 214. 最短回文串
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 *
 * 示例 1:
 *
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 *
 * 输入: "abcd"
 * 输出: "dcbabcd"
 */
public class SL_214_shortestPalindrome {
    public String shortestPalindrome(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int i = 0;
        for (; i < n; i++) {
            if (s.substring(0, n - i).equals(r.substring(i))) {
                break;
            }
        }
        return new StringBuilder(s.substring(n - i)).reverse() + s;
    }

}
