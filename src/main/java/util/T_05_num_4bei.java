package util;

import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/24 9:35
 *
 *
 * 小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
 * 牛博士给小易出了一个难题:
 * 对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
 * 小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
 *
 * 输入描述:
 * 输入的第一行为数列的个数t(1 ≤ t ≤ 10),
 * 接下来每两行描述一个数列A,第一行为数列长度n(1 ≤ n ≤ 10^5)
 * 第二行为n个正整数A[i](1 ≤ A[i] ≤ 10^9)
 *
 * 输出描述:
 * 对于每个数列输出一行表示是否可以满足牛博士要求,如果可以输出Yes,否则输出No。
 *
 * 示例1
 * 输入
 * 2
 * 3
 * 1 10 100
 * 4
 * 1 2 3 4
 *
 * 输出
 * Yes
 * No
 */
public class T_05_num_4bei {

    public static void  main(String[] args){
        Scanner in = new Scanner(System.in);
        //ArrayList<String> list = new ArrayList<String>();
        while(in.hasNext()){
            //输入第一行为数列的个数t
            int t = in.nextInt();
            //下面每两行描述一个数列A
            for(int i = 0;i<t;i++){
                //第一行为数列长度n
                int n = in.nextInt();
                int a[] = new int[n];
                for(int j = 0;j<n;j++){
                    //第二行为数列
                    a[j] = in.nextInt();
                }
                int mod4_num=0 , mod2_num=0,odd=0;
                //对数组数进行遍历
                for(int k = 0;k<a.length;k++){
                    if(a[k] % 4 ==0){
                        //索引++
                        mod4_num++;
                    }else if(a[k] % 2 ==0){
                        mod2_num++;
                    }else{
                        odd++;
                    }
                }
                //存在 2 的倍数，所有 2 的倍数相邻排列，
                // 需要一个 4 的倍数连接剩下的数，奇数最多和 4 的倍数数量相等，要求 mod4_num >= odd
                if(mod2_num > 0){
                    if(mod4_num >= odd){
                        System.out.println("Yes");
                    }else{
                        System.out.println("No");
                    }
                }else{
                    //没有 2 的倍数，原本放 2 的倍数一端可以改放一个奇数，mod4_num >= odd - 1
                    if(mod4_num >=(odd-1)){
                        System.out.println("Yes");
                    }else{
                        System.out.println("No");
                    }
                }
            }
        }

    }
}
