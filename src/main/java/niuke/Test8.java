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
 * 将字符串输出为最短回文字符串
 * 输入  abc
 * 输出  abcb
 *
 * 输入  noo
 * 输出  noon
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
                s=addword(s);
                break;
            }
            ++l;
            --r;
        }
        return s;

    }
    public String addword(String s){
//        StringBuffer word = new StringBuffer();
//        char[] m = s.toCharArray();
//        char[] w = new char[300];
//        String X ="";
//        for (int i = m.length-1; i >=0 ; i--) {
//            X +=  m[i];
//            //word.append(m[i]);
//        }
////        for (int i = 0; i <s.length(); i++) {
////            word.append(w[i]);
////        }
//        //word.append(s);
//        //word.append(s).append(m);
//
//        String F="";
//        s = s+X;
//       return  s;

        char[] h = s.toCharArray();
        if(h == null || h.length == 0) return s;

       // char[] h = new char[300];
        int left = 0;

        int right = h.length-1;
        while(left < right) {  //奇数个的时候中间元素不动
            char temp = h[left];
            h[left] = h[right];
            h[right] = temp;
            left++;
            right--;
        }
        return s;
    }
}
