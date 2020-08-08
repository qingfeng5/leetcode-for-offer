package niuke;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/8/8 15:06
 */
public class Test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s =sc.nextLine();
           // char[] ch =word.toCharArray();
            String word = new Test8().word(s);
            System.out.println(word);
        }
    }
    public String word(String s){
        if (s == null || s.length() ==0){
            return "";
        }
        char[] m = new char[300];
        StringBuffer word = new StringBuffer();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch =  s.charAt(i);
            if (Character.isLetterOrDigit(ch)){
                word.append(Character.toLowerCase(ch));
            }
        }
        int n = word.length();
        int l = 0, r = n-1;
        while (l<r){
            if (Character.toLowerCase(word.charAt(l)) !=  Character.toLowerCase(word.charAt(r))){
                addword(s);
            }
            ++l;
            --r;
        }
        return s;

    }
    public String addword(String s){
        StringBuffer word = new StringBuffer();
        char[] m = new char[300];
        char[] w = new char[300];
        for (int i = s.length(); i >=0 ; i--) {
            word.append(m[i]);
        }
//        for (int i = 0; i <s.length(); i++) {
//            word.append(w[i]);
//        }

        //word.append(s);
        return (s+m).trim().toString();
    }
}
