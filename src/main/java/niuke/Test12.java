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

        char[] str = new char[3000];
        if (w.length > 3000){
            return;
        }
        int l =0;
        for (int i = 0; i <w.length-1 ; i++) {
            if ((w[i] != 'n')){
                str[i] = w[i];
                l++;
            }
            else {
                str[i] =w[i-1];
            }
            else if (l<w.length-1){

            }
        }

        System.out.println(str.toString());
    }
}
