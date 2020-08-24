package util;

import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/24 10:31
 */
public class T_02_02_input_nums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //打印输出n行数组
        int x[] = new int[n];
        for (int i = 0; i < n; i++)
            x[i] = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(x[i]);
        }
    }
}
