package niuke;

import java.util.Scanner;

/**
 * 有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。
 * 请设计一个算法，计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。
 *
 * 输入描述:
 * 输入包括一行，空格隔开的两个正整数x和y，取值范围[1,10]。
 *
 * 输出描述:
 * 输出一行，表示走法的数目
 *
 * 输入例子1:
 * 3 2
 *
 * 输出例子1:
 * 10
 */
public class S2019_mogujie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(f(x,y));
    }

    public static int f(int x,int y) {
        if(x==1) return y+1;
        if(y==1) return x+1;
        return f(x-1,y)+f(x,y-1);
    }
}
