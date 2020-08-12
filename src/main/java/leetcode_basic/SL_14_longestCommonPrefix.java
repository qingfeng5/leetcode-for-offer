package leetcode_basic;

/**
 * Created by 清风
 * 2020/8/12 19:35
 *14. 最长公共前缀
 * 简单
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * */

public class SL_14_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        //当字符串数组长度为 0 时则公共前缀为空，直接返回
        if(strs.length == 0)
            return "";

        //令最长公共前缀 ans 的值为第一个字符串，进行初始化
        String ans = strs[0];

        //遍历后面的字符串，依次将其与 ans 进行比较，两两找出公共前缀，最终结果即为最长公共前缀
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                //如果查找过程中出现了 ans 为空的情况，则公共前缀不存在直接返回
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }

}
