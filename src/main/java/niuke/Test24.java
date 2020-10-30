package niuke;

import java.util.Map;
import java.util.Scanner;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/10/30 17:54
 * 给定一个整数str =abcde, str2= abc  ,
 * 求str1 的字串中所有含有str2所有字符 的最小字串长度
 */
public class Test24 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int num  = new Test24().length(str1,str2);
        System.out.println(num);
    }
    public int length(String str1,String str2){
        if (str1 == null || str2 ==null || str1.length() <str2.length()){
            return 0;
        }
        char[] word1 =str1.toCharArray();
        char[] word2 =str2.toCharArray();
        int[] map =new int[256];
        for (int i =0; i<word2.length;i++){
            map[word2[i]]++;
        }
        int left =0;
        int right =0;
        int min = Integer.MAX_VALUE;
        int match = word2.length;
        while (right != word1.length){
            map[word1[right]]--;
            if (map[word1[right]] >= 0){
                match--;
            }
            if (match == 0){
                while (map[word1[left]] <0){
                    map[word1[left++]]++;
                }
                min = Math.min(min,right-left+1);
                match++;
                map[word1[left++]]++;
            }
            right++;
        }
        return min ==Integer.MAX_VALUE ? 0:min;
    }
}
