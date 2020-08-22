package niuke;

import java.util.Scanner;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/8/21 20:00
 */
public class T_02_didi_num_print {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1){
            System.out.println(1);
        }
        long[][] res = get(n);
        for(long[] i : res){
            for(long j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static long[][] get(int n){
        long[] arr = new long[n*n];
        arr[0] = arr[1] = 1l;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        long[][] res = new long[n][n];
        int up = 0,down = n - 1,left = 0,right = n - 1;
        int index = arr.length - 1;
        while (true){
            for (int i = left; i <= right; i++) {
                res[up][i] = arr[index--];
            }
            if (++up > down){
                break;
            }
            for (int i = up; i <= down; i++) {
                res[i][right] = arr[index--];
            }
            if (--right < left){
                break;
            }
            for (int i = right; i >= left; i--) {
                res[down][i] = arr[index--];
            }
            if (--down < up){
                break;
            }
            for (int i = down; i >= up; i--) {
                res[i][left] = arr[index--];
            }
            if (++left > right){
                break;
            }
        }
        return res;
    }

}
