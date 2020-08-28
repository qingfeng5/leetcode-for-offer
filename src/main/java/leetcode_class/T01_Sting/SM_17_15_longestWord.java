package leetcode_class.T01_Sting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 清风
 * 2020/8/28 11:15\
 * 中等
 * 面试题 17.15. 最长单词
 * 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。
 * 若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
 *
 * 示例：
 *
 * 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
 * 输出： "dogwalker"
 * 解释： "dogwalker"可由"dog"和"walker"组成。
 */
public class SM_17_15_longestWord {
    //先把字符串数组排序，字符串长的在前面，
    // 相同长度的字典序小的在前面，排好序后加入到set里判断是否包含，
    // 从第一个字符串开始判断，看是否由其它字符串组成，这里可以用递归

    public String longestWord(String[] words) {
        Arrays.sort(words,(o1, o2)->{
            if(o1.length() == o2.length())
                return o1.compareTo(o2);
            else{
                return Integer.compare(o2.length(),o1.length());
            }
        });

        Set<String> set = new HashSet<>(Arrays.asList(words));
        for(String word : words){
            set.remove(word);
            if(find(set,word))
                return word;
        }
        return "";
    }

    //递归出口： 如果字符串长的长度为0，说明遍历完了，之前的都满足条件，返回true
    //递归操作： 遍历字符串的第0个位置开始，判断set里是否有，
    // 如果0到i的字符串正好包含在set里，下次从i+1的位置开始判断，
    // 直到遍历完了，字符串长度为0，没找到则返回false
    public boolean find(Set<String> set, String word){
        if(word.length() == 0)
            return true;
        for(int i = 0; i < word.length(); i++){
            if(set.contains(word.substring(0,i+1)) && find(set,word.substring(i+1)))
                return true;
        }
        return false;
    }

}
