package niuke;

import java.util.Scanner;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/9/9 16:33
 */
public class Test22 {
    public static void main(String[] args) {
        System.out.println("请输入一个整数:");
        Scanner sc=new Scanner(System.in);
        String a = sc.next();
        int num  = new Test22().stringcount(a);
        System.out.println(num);
    }
    public int stringcount(String s){
        int n = s.length();
        int index = 0;
        if (n <= 1){
            index=0;

        }
        char[] str =s.toCharArray();
        StringBuffer a = new StringBuffer();
        for (int i = 0; i < 2 * n-1; i++) {
            int l = i / 2;
            int r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                if (s.substring(l,r).length()<2){
                    index=0;
                }
                --l;
                ++r;
                ++index;
            }
        }
        return index;
    }
}
