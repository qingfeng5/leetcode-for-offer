package niuke;

import java.util.Scanner;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/10/30 18:00
 * 求两整数之和，不使用+、- * /运算符号
 * 输入10，15
 * 输出25
 *
 */
public class Test23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long num  = new Test23().TwoSum(a,b);
        System.out.println(num);
    }
    public long TwoSum(long a, long b){
        int p = 1000000007;
        if (b ==0){
            return a;
        }
        while (b != 0){
            long sum = (a & b) << 1;
            a ^= b;
            b = sum;
        }
        return a%p;
    }
}
