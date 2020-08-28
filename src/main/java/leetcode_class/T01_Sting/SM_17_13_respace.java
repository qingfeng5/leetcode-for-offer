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
public class SM_17_13_respace {
    public int respace(String[] dictionary, String sentence) {
        Set<String> dic = new HashSet<>();
        for(String str: dictionary)
            dic.add(str);

        int n = sentence.length();
        //dp[i]表示sentence前i个字符所得结果
        int[] dp = new int[n+1];
        //dp[0]=0 表示句子是空字符串时没有未识别的字符，dp[i] 表示句子前 i 个字符中最少的未识别字符数。
        for(int i=1; i<=n; i++){
            //对于前 i 个字符，即句子字符串的 [0,i)，
            // 它可能是由最前面的 [0,j)子字符串加上一个字典匹配的单词得到，也就是 dp[i]=dp[j], j<i；
            //先假设当前字符作为单词不在字典中
            dp[i] = dp[i-1]+1;
            for(int j=0; j<i; j++){
                //sentence.substring(j,i)截取j到i的索引的字符串
                //如hello world （0，5）就是hello
                if(dic.contains(sentence.substring(j,i))){
                    //即使前面存在匹配的单词，也不能保证哪一种剩下的字符最少，所以每轮都要比较一次最小值。
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[n];
    }
}

