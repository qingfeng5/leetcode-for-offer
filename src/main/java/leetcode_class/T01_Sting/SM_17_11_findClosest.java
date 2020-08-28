package leetcode_class.T01_Sting;

import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/28 10:48
 * 中等
 * 面试题 17.11. 单词距离
 * 有个内含单词的超大文本文件，给定任意两个单词，
 * 找出在这个文件中这两个单词的最短距离(相隔单词数)。
 * 如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 *
 * 示例：
 *
 * 输入：
 * words = ["I","am","a","student","from","a","university","in","a","city"],
 * word1 = "a", word2 = "student"
 * 输出：1
 */
public class SM_17_11_findClosest {

    public static void main(String[] args) {
        System.out.println("请输入一个整数:");
        Scanner sc=new Scanner(System.in);
        //输如一个n，再接着输入n行字符串，
        int n = sc.nextInt();
        String[] strs = new String[n];
        //输入字符组words = ["I","am","a","student","from","a","university","in","a","city"],
        for (int i=0;i<strs.length;i++){
            strs[i] = sc.next();
        }
        //输入两个字符
        String a = sc.next();
        String b = sc.next();
        int s  = new SM_17_11_findClosest().findClosest(strs,a,b);
        System.out.println(s);
    }
    // TODO: 2020/8/28 双指针 
    public int findClosest(String[] words, String word1, String word2) {
        int w1 = 0, w2 = 0, close = 0;
        boolean hasChange = false;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                w1 = i;
                hasChange = true;
            } else if (word2.equals(words[i])) {
                w2 = i;
                hasChange = true;
            }
            if (w1 != 0 && w2 != 0 && hasChange == true) {
                if (close == 0) {
                    close = Math.abs(w2 - w1);
                } else {
                    close = Math.min(close, Math.abs(w2 - w1));
                }
                if (close == 1) {
                    return 1;
                }
                hasChange = false;
            }
        }
        return close;

    }
}
