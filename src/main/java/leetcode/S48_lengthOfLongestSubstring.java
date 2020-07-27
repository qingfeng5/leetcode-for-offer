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
public class S48_lengthOfLongestSubstring {
    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.isEmpty())
            return 0;
        char[] cs = s.toCharArray();
        //cMap=int[256]替代了HashMap
        //cMap记录s[r]字符最近出现的位置+1（也即，重复字符取最大的位置+1）,cMap[s[r]] = r+1;
        int[] cMap = new int[256];
        //l,r分别为窗口的左侧和右侧；
        //每次将r向右移动一位，
        int l = 0, r = 0;
        int ans = 0;

        while(r < cs.length){
            //如果cMap[s[r]] <= l表示该字符在l到r的窗口中未出现过,ans 取 r-l+1与ans 的较大值，回到3
            if(cMap[cs[r]] <= l)
                ans = Math.max(r-l+1,ans);
            else
                //当cMap[s[r]] > l 表示该字符在l到r的窗口中出现过，令l=cMap[s[r]],则该字符就未在l到r中出现，回到3
                l = cMap[cs[r]];
            cMap[cs[r]] = r+1;
            ++r;
        }
        return ans;
    }
}
