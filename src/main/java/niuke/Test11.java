package niuke;

import java.util.Scanner;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/8/22 20:44
 */
public class Test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String res = null;
        for (int i = 0; i < n; i++) {
             res = sc.nextLine();
        }
        int num = new Test11().length(res);
        System.out.println(num);
    }
    public int length(String res){

        char[] c =res.toCharArray();
        int count =0;
        String len ="";
        for (int i = 0; i <c.length ; i++) {
            //char ch =  res.charAt(i);
            len = Integer.toBinaryString(c[i]);
            if (len.length()<=10){
                count++;
            }
        }
        return count;
    }
}
