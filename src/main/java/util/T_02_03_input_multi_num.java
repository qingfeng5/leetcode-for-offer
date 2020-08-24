package util;

import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/24 10:33
 */
public class T_02_03_input_multi_num {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //打印输出n行 ,m列数组
        int x[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                x[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(x[i][j]);
            }

        }
    }
}
