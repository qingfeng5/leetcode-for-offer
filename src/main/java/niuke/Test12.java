package niuke;

import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/24 9:36
 */
public class Test12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuffer word = new StringBuffer();
        char[] w = s.toCharArray();
        for (int i = 0; i < w.length-1 ; i++) {
            word.append(w[i]);
        }
        String[] str = s.split("\\n");

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
        System.out.println(str.toString());
    }
}
