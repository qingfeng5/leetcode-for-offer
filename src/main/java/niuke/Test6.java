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

        //double i = new Test6().sum(n);
        double s = 0;
        double sum = 0;
        //String str = null;
//        if (n ==1){
//            return sum = 0.1000;
//        }

        for (double i = 1; i <=n; i++) {
            sum = sum + (1 / (5 * (2 * i-1))) *( 2 * i);
            //sum = Math.round(s*100)/100;
            //System.out.println(sum);
            System.out.println(String.format("%.4f" ,sum));
        }
    }

}
