package util;

import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/24 10:31
 */
public class T_02_02_input_nums_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();//读入一行string
        String[] c=s.split("\\s+");//根据空格进行分割
        int[] arr=new int[c.length];
        for(int i=0;i<c.length;i++) {
            arr[i]=Integer.parseInt(c[i]);//将string转为int型
        }
    }
}
