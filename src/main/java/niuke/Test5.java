package niuke;

import java.util.Scanner;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/8/2 15:05
 */
public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String res = null;

        for (int i = 0; i < 4; i++) {
           res = sc.next();
        }

        int i = new Test5().totalWords(res);
        System.out.println(i);
    }


    public int totalWords(String res) {
        //双指针
        int r = res.length() - 1,  l= 0;
        int count=0;
        while(r < res.length()) {
            if(res.charAt(r) == res.charAt(l)){
                l++;
            }else {
                count++;
            }

        }
        return count;
    }
}
