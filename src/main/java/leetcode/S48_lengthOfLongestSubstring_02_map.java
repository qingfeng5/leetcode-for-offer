package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/7/27 20:35
 *
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class S48_lengthOfLongestSubstring_02_map {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), res = 0;
        //key出现的字符，value对应的最新的位置
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int end = 0, start = 0; end < n; end++) {
            // 指针 j 遍历字符 s ，哈希表统计字符 s[j] 最后一次出现的索引 。
            if (map.containsKey(s.charAt(end))) {
                //更新左指针 i ： 根据上轮左指针 i 和 dic[s[j]]，每轮更新左边界 i ，
                // 保证区间 [i + 1, j]内无重复字符且最大。
                //由于重复的坐标不知道在start的前方还是后方，所以要取个最大值
                start = Math.max(map.get(s.charAt(end)) + 1, start);
            }
            //取上轮 res 和本轮双指针区间 [i + 1,j] 的宽度（即 j - i）中的最大值
            res = Math.max(res, end - start + 1);
            map.put(s.charAt(end), end);
        }
        return res;
    }

}
