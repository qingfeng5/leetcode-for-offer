package leetcode_class.T01_Sting;

import java.util.HashMap;

/**
 * Created by 清风
 * 2020/8/12 19:17
 *中等
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
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
public class SL_03_lengthOfLongestSubstring {
    // TODO: 2020/8/12  滑动窗口 | 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;//最长子串长度
        int left = 0;//滑动窗口左下标，i相当于滑动窗口右下标

        for(int i = 0; i < s.length(); i ++){
            //charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
            if(map.containsKey(s.charAt(i))){
                //map.get():返回字符所对应的索引，当发现重复元素时，窗口左指针右移
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            //再更新map中a映射的下标
            map.put(s.charAt(i),i);
            //比较两个参数的大小
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
