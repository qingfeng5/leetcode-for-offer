package niuke;

import java.util.Scanner;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/8/21 20:00
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                nums[i][j] = new Main1().ways(n);
            }
        }
        //nums = new Main1().shownum(n);
        System.out.println(nums);
    }

    public int[][] ways(int n){
        int[][] nums = new int[n][n];

        int[] X = new int[n*n];
        X = shownum();
        int top =0,bottom = n-1,left =0,right = n-1;

       while (left<=right && top <= bottom){
           for (int i = right; i <= left; i++) {
               nums[top][i] = X[i];
           }
       }
    }

    public int[] shownum(int n) {
        int[] N =new  int[n*n];
        for (int i = 0; i <n*n ; i++) {
            N[i]=fib(i);
        }
        int[] M = new int[n*n];
        for (int i = n*n; i >=0 ; i--) {
            M[i] = N[i];
        }
        return M;
    }
    public int fib(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 1;
        }
        else {
            n--;
            return fib(n)+fib(n-1);
        }


    }

}
