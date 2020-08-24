package util;

import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/24 9:26

 *
 * 为了得到1325的"相反数",
 * 首先我们将该数的数字顺序颠倒,我们得到5231,
 * 之后再加上原先的数,我们得到
 * 5231+1325=6556.如
 * 果颠倒之后的数字有前缀零,前缀零将会被忽略。
 * 例如n = 100, 颠倒之后是1.
 */
public class T_03_wangyi_num_reserve {
    // TODO: 2020/8/24 数字反转相加
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();

        StringBuffer sb = new StringBuffer(num);
        StringBuffer sbr = new StringBuffer(num).reverse();
        //5321
        System.out.println(Integer.parseInt(sb.toString()));
        //5321+1235
        System.out.println(Integer.parseInt(sb.toString())+Integer.parseInt(sbr.toString()));
    }
}
