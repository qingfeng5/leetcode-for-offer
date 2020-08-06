package niuke;

import java.util.Scanner;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/8/6 20:06
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double i = new Test6().sum(n);
        System.out.println(i);
    }

    public double sum(int n){
        double s = 0;
        //String str = null;
        if (n<=1){
            return 0.1000;
        }
        for (int i = 0; i <n; i++) {
            s = s + 1 / (5 * (2 * n-1))-1 / (5 * 2 * n);
            s = Math.round(s*100)/100;
            //s = ()String.format("%.4f" ,s);

        }
        return s;
    }
}
