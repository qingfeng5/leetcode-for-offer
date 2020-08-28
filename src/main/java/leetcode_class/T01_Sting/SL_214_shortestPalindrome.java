package leetcode_class.T01_Sting;

/**
 * Created by 清风
 * 2020/8/28 13:26
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
    // TODO: 2020/8/28 最短回文串  双指针+拼接   "abcd"  -》 dcbabcd"
    public String shortestPalindrome(String s) {
        int i = 0;
        int n = s.length();
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i += 1;
            }
        }
        // 经过上面走完后，i 位于回文串的最后一位，例如：
        // aacecaaa
        //        i
        if (i == n) {
            return s;
        }

        // 定义后缀，中间部分，前缀，最后拼接起来即可
        String suffix = s.substring(i);
        // substring() 左闭右开原则，所以这里取不到最后的 a
        //截取0到i索引位置的字符
        String mid = shortestPalindrome(s.substring(0,i));
        String prefix = new StringBuilder(suffix).reverse().toString();
        String ans = prefix + mid + suffix;
        return ans;
    }

}
