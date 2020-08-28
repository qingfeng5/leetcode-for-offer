package leetcode_class.T01_Sting;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/7/16 20:52
 *
 * 剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 */
public class S58_reverseLeftWords_02 {
    public String reverseLeftWords(String s, int n) {
        //新建一个StringBuilder，记为 res ；
        StringBuilder res = new StringBuilder();
        //先向 res 添加 “第 n + 1位至末位的字符” ；
        for(int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        //再向 res添加 “首位至第 n 位的字符” ；
        for(int i = 0; i < n; i++)
            res.append(s.charAt(i));
        //将 res 转化为字符串并返回。
        return res.toString();
    }
}


