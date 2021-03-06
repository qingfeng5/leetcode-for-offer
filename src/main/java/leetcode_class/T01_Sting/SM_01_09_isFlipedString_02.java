package leetcode_class.T01_Sting;

/**
 * Created by 清风
 * 2020/9/27 17:13
 * 简单
 * 面试题 01.09. 字符串轮转
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 * 示例2:
 *
 *  输入：s1 = "aa", s2 = "aba"
 *  输出：False
 */
public class SM_01_09_isFlipedString_02 {
    public boolean isFlipedString(String s1, String s2)
    {
        return s1.equals(s2)
                ||(s1.length()==s2.length()
                &&(s1+s1).contains(s2));
    }
}
