package leetcode_basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 清风
 * 2020/8/26 19:46
 * 困难
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 */
public class SL_30_findSubstring {

    //滑动窗口
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        //单词个数、单词长度
        int wordNum = words.length, wordLen = words[0].length();
        //将words每个单词及其个数存入hashmap
        HashMap<String, Integer> allWords = new HashMap<>();
        for (String word : words) {
            Integer value = allWords.getOrDefault(word, 0);
            allWords.put(word, ++value);
        }
        //遍历s每一个子串,剩余不足wordNum*wordLen个字符的子串不需要遍历
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            //将子串中出现的和words中相等的单词及其出现次数存入hashmap
            HashMap<String, Integer> hasWords = new HashMap<>();
            //记录字串中和words中相等单词数量
            int count = 0;
            //统计字串中连续和words中相等的单词
            while (count < wordNum) {
                String word = s.substring(i + count * wordLen, i + (count + 1) * wordLen);
                //如果word匹配words中的单词，就统计其出现次数
                if (allWords.containsKey(word)) {
                    Integer value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word, ++value);
                    //如果word出现次数超过words中这个单词的总数量则结束统计
                    if (hasWords.get(word) > allWords.get(word)) break;
                } else {
                    //如果字串中出现于words中所有单词都不匹配的word则结束统计
                    break;
                }
                //增加成功与words中匹配的单词数量
                count++;
            }
            if (count == wordNum) res.add(i);
        }
        return res;
    }
}
