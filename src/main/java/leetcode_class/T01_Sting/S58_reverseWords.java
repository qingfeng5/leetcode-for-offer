package leetcode_class.T01_Sting;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/7/16 20:28
 *
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class S58_reverseWords {
    public String reverseWords(String s) {

        s = s.trim(); // 删除首尾空格
        //倒序遍历字符串 s ，记录单词左右索引边界 i , j ；
        int j = s.length() - 1, i = j;
        //每确定一个单词的边界，则将其添加至单词列表 res ；
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            // 搜索首个空格
            while(i >= 0 && s.charAt(i) != ' ')
                i--;

            // 添加单词
            res.append(s.substring(i + 1, j + 1) + " ");

            // 跳过单词间空格
            while(i >= 0 && s.charAt(i) == ' ')
                i--;
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }
}
