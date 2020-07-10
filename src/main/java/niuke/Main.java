package niuke;


import java.util.Scanner;

/**
 * 给定N个矩形，每个矩形宽W米高H米
 *         请按以下规则将这N个矩形排序，输出排序后的矩形列表
 *
 *         排序规则：
 *         面积小的矩形排在面积大的矩形前面
 *         面积相同的矩形，按照宽高比排序，宽高比大的矩形排在宽高比小的矩形前面
 *         宽高比的定义为 min(W/H, H/W)
 *         面积和宽高比都相同的矩形，按照宽排序，宽度更小的矩形排在宽度更大的矩形前面
 *
 *         输入描述:
 *         每组输入两行输入
 *
 *         第一行是一个整数N （0 < N <= 100)
 *
 *         第二行是2*N个整数，分别是每个矩形的宽W和高H，(0 < W,H <= 100)
 *
 *         输出描述:
 *         每组数据输出一行，2*N个整数，分别是排序后的每个矩形的宽W和高H
 *
 *         输入例子1:
 *         2
 *         2 2 1 1
 *
 *         输出例子1:
 *         1 1 2 2
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[2*n];
        for (int i = 0; i <2*n ; i++) {
            w[i] = sc.nextInt();
        }

        for (int i = 0; i <2*n ; i+=2) {
            for (int j = i+2; j <2*n ; j+=2) {
                if(w[j]*w[j+1]<w[i]*w[i+1]){
                    swap(w,j,i);
                    swap(w,j+1,i+1);
                }else if ((w[j]*w[j+1]==w[i]*w[i+1])&&(Math.min(w[j]/w[j+1],w[j+1]/w[j])>Math.min(w[i]/w[i+1],w[i+1]/w[i]))){
                    swap(w,j,i);
                    swap(w,j+1,i+1);
                }else if ((w[j]*w[j+1]==w[i]*w[i+1])&&(Math.min(w[j]/w[j+1],w[j+1]/w[j])==Math.min(w[i]/w[i+1],w[i+1]/w[i]))&&w[j]<w[i]){
                    swap(w,j,i);
                    swap(w,j+1,i+1);
                }
            }
        }
        for (int i = 0; i < 2*n ; i++) {
            if(i!=2*n-1) {
                System.out.print(w[i] + " ");
            }else {
                System.out.print(w[i]);
            }
        }

    }

    public static void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
