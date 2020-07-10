package leetcode;

/**
 * 面试题05. 替换空格
 * Created by 清风
 * 2020/5/8 13:57
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 初始化一个 StringBuilder ，记为 res ；
 * 遍历字符串 s 中的每个字符 c ：
 * 当 c 为空格时：向 res 后添加字符串 "%20"；
 * 当 c 不为空格时：向 res 后添加字符 c ；
 * 将 res 转化为 String 类型并返回

 */
public class S05_ReplaceSpace_00 {

    /***
     * 初始化一个 StringBuilder ，记为 res ；
     * 遍历字符串 s 中的每个字符 c ：
     * 当 c 为空格时：向 res 后添加字符串 "%20"；
     * 当 c 不为空格时：向 res 后添加字符 c ；
     * 将 res 转化为 String 类型并返回
     */
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' '){ res.append("%20");}
            else {res.append(c);}
        }
        return res.toString();
    }
}
