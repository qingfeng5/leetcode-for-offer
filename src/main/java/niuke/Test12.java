package niuke;

import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/24 9:36
 */
public class Test12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //打印输出n行数组
        int x[] = new int[n];
        for (int i = 0; i < n; i++)
            x[i] = sc.nextInt();

        //打印输出两行字符串
        StringBuilder[] strs = new StringBuilder[n];
        for (int i=0;i<n;i++){
            strs[i] = new StringBuilder(sc.next());
        }
        System.out.println(strs);
    }
}
