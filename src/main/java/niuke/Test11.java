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
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String temp="";
        for(int i=1;i<=n;i++){
            System.out.println("请输入第"+i+"行字符串");
            temp += scanner.next();
        }
        int num = new Test11().length(n,temp);
        System.out.println(num);
    }
    public int length(int n,String res){

        char[] c =res.toCharArray();
        int count =0;
        String len ="";
        int l = 0;

        for (int i = 0; i <n ; i++) {
            //char ch =  res.charAt(i);

            while (l < c.length){
                if (c.length<=10 ){
                    if ((c[l] != ' ') ){
                        count++;
                    }
                }
            }
        }
        return count;

    }
}
