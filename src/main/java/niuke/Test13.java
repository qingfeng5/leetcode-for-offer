package niuke;

import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/24 12:35
 * 将字符串以n分割成字符串
 *输入
 *dssnsdns
 * 输出
 * Dss
 * Nsd
 * Ns
 */
public class Test13 {
    public static void main(String[] args) {
       // Scanner sc = new Scanner(System.in);
       // String s = sc.nextLine();

       //char[] str =s.toCharArray();
        char[] str = new char[3];
        String s ="sadnsadsd";
        StringBuilder x = new StringBuilder();
//        for (int j = 0; j < s.length(); j++) {
//            for (int k = 0; k <s.length() ; k++) {
//                if ( (s.charAt(k) == 'n')){
//                    //x.append(s.charAt(r+1-l));
//                    x.append(s.charAt(r));
////                l=r+1;
////                r++;
////                i++;
//                }
//            }
//        }
        int l=0;
        int r=-1;
        while (r+1<s.length()){
            if ( s.charAt(r+1) == 'n'){
                x.append(s.charAt(r));
                r++;
            }

        }
        System.out.println(x.toString());
    }
}
