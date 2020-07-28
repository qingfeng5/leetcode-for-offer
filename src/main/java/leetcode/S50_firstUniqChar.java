package leetcode;

import java.util.HashMap;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/7/28 22:17
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 简单
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 */
public class S50_firstUniqChar {
    //初始化： 字典（Python）、HashMap（Java），记为 dic ；
    //字符统计： 遍历字符串 s 中的每个字符 c ；
    //若 dic 中 不包含 键(key) c ：则向 dic 中添加键值对 (c, True) ，代表字符 c 的数量为 1；
    //若 dic 中 包含 键(key) c ：则修改键 c 的键值对为 (c, False) ，代表字符 c 的数量 > 1 。
    //查找数量为 11 的字符： 遍历字符串 s 中的每个字符 c ；
    //若 dic中键 c 对应的值为 True ：，则返回 c 。
    //返回 ' ' ，代表字符串无数量为 1 的字符。

    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }

}
