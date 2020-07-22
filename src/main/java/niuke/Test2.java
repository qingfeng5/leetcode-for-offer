package niuke;

import java.util.Scanner;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/7/17 19:14
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        //int ans = 0, x;
        int[][] nums = new int[4][m];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < m; j++){
                nums[i][j] = sc.nextInt();
            }
        }
        int sum =   new Solution().MaxValue(n, m , c,d,nums);
        System.out.println(sum);
    }
}
class Solution{
    int sum=0;
    int num=0;
    public int MaxValue(int n, int m, int c, int d ,int[][] nums){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < m; j++){
                while ( n>=0 && n-(nums[i][1]/nums[i][2])>=0){

                    sum = sum+ (nums[i][1]/nums[i][2])*c;

                }
            }
        }
        return sum;
    }
}
