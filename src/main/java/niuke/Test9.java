package niuke;

import java.util.Scanner;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/8/8 16:12
 */
public class Test9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        int i = new Test9().maxnum(num);
        System.out.println(i);
    }
    public int maxnum(int[] num){
        int count = 0;
        if (num.length == 0){
            return 0;
        }
        int i= 0;
        while (i < num.length){
            if(num[i] == 1) {
                count = 0;
            }
            else if (num[i]==2){
                count = 1;
            }
            else {
                for (int j = 3; j < num.length; j+=2) {
                    if (num[i] == 0){
                        count++;
                        int temp =j+j;
                        int s = temp+j;
                        while (s <= num.length){
                            num[s] =1;
                            s += temp;
                        }
                    }
                }
            }
        }

        return count;
    }
}
