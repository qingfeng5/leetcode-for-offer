package leetcode_class.T01_Sting;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 清风
 * 2020/8/28 9:52
 * 中等
 * 面试题 17.13. 恢复空格
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。
 * 像句子"I reset the computer. It still didn’t boot!"
 * 已经变成了"iresetthecomputeritstilldidntboot"。
 * 在处理标点符号和大小写之前，你得先把它断成词语。
 * 当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。
 * 假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 *
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数

 * 示例：
 *
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 *
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 */
public class SM_17_13_respace_02 {
    /**
     * 自定义一个TrieNode类型。
     * 这里不用建一个变量来存当前节点表示的字符，
     * 因为只要该节点不为null，就说明存在这个字符
     */
    class TrieNode {
        TrieNode[] childs;
        boolean isWord;

        public TrieNode() {
            childs = new TrieNode[26];
            isWord = false;
        }
    }

    TrieNode root;  //空白的根节点，设为全局变量更醒目

    public int respace(String[] dictionary, String sentence) {
        root = new TrieNode();
        makeTrie(dictionary);   //创建字典树
        int n = sentence.length();
        int[] dp = new int[n + 1];
        //这里从sentence最后一个字符开始
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = n - i;    //初始默认后面全不匹配
            TrieNode node = root;
            for (int j = i; j < n; j++) {
                int c = sentence.charAt(j) - 'a';
                if (node.childs[c] == null) {
                    //例如"abcde",i=1,j=2 可找出长度关系
                    dp[i] = Math.min(dp[i], j - i + 1 + dp[j + 1]);
                    break;
                }
                if (node.childs[c].isWord) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                } else {
                    dp[i] = Math.min(dp[i], j - i + 1 + dp[j + 1]);
                }
                node = node.childs[c];
            }
        }
        return dp[0];
    }

    public void makeTrie(String[] dictionary) {
        for (String str : dictionary) {
            TrieNode node = root;
            for (int k = 0; k < str.length(); k++) {
                int i = str.charAt(k) - 'a';
                if (node.childs[i] == null) {
                    node.childs[i] = new TrieNode();
                }
                node = node.childs[i];
            }
            node.isWord = true; //单词的结尾

        }
    }
}
