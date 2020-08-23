package niuke;

import java.util.Scanner;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/8/22 20:44
 */
public class Test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String res ="";
        for (int i = 0; i <3; i++) {
            res = sc.nextLine();
        }
        int num = new Test11().length(n,res);
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
