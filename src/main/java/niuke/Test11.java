package niuke;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/8/22 20:44
 */
public class Test11 {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入一个整数:");
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        //打印输出两行字符串
        StringBuilder[] strs = new StringBuilder[n];
        for (int i=0;i<n;i++){
            strs[i] = new StringBuilder(sc.next());
        }
        int num = new Test11().length(n,strs);
        System.out.println(num);
    }
    public int length(int n, StringBuilder[] res){


        int count =0;
        String len ="";
        int l = 0;

        for (int i = 0; i <n ; i++) {
            //char ch =  res.charAt(i);

            while (l < res.length){
                if (res.length<=10 ){
                    if ((res[l] != null) ){
                        count++;
                    }
                }
            }
        }
        return count;

    }
}
