package niuke;

import leetcode_class.T01_Sting.SM_17_11_findClosest;

import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/28 11:13
 */
public class Test14 {
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
        int s  = new Test14().way(strs,a,b);
        System.out.println(s);
    }
    public int way(String[] words, String word1, String word2){
        int i=0;



        return i;
    }
}
