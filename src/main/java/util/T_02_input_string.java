package util;

import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/24 8:50
 */
public class T_02_input_string {
    public static void main(String[] args) {
        System.out.println("请输入一个整数:");
        Scanner sc=new Scanner(System.in);
        //输如一个n，再接着输入n行字符串，
        int n = sc.nextInt();
        StringBuilder[] strs = new StringBuilder[n];
        for (int i=0;i<n;i++){
            strs[i] = new StringBuilder(sc.next());
        }
       //打印输出每行字符串
        for (int i = 0; i < n; i++) {
            System.out.println(strs[i].toString());
        }
        System.out.println(strs);
    }
}
