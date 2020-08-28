package leetcode_class.T01_Sting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 清风
 * 2020/8/28 10:25
 * 中等
 * 面试题 10.02. 变位词组
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 *
 * 注意：本题相对原题稍作修改
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class SM_10_02_groupAnagrams {
    // TODO: 2020/8/28  变位词组 变位词是指字母相同，但排列不同的字符串
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        HashMap<String, List<String>> map = new HashMap<>(len);
        for (String str : strs) {
            int[] count = new int[26];
            int str_len = str.length();
            for (int i = 0; i < str_len; ++i)
                ++count[str.charAt(i) - 'a'];
            StringBuilder sb = new StringBuilder(100);
            for (int num : count)
                sb.append(num + '.');
            map.computeIfAbsent(sb.toString(), unused -> new LinkedList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
