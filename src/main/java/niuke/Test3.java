//package niuke;
//
//import java.util.Scanner;
//
///**
// * @Classname: qingfeng
// * @Author: 清风
// * @Date: 2020/8/1 15:52
// */
//public class Test3 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int s = sc.nextInt();
//        int n = sc.nextInt();
//        int[][] nums = new int[n][2];
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < 2; j++){
//                nums[i][j] = sc.nextInt();
//            }
//        }
//        int value =   new Solution().MaxValue(s, n,nums);
//        System.out.println(value);
//    }
//}
//class Solution{
//
//
//    int value= 0;
//    int sum = 0;
//    public int MaxValue(int s, int n ,int[][] nums){
//        int l = 0;
//        int i = nums.length-1;
//        if (nums.length<3){
//            return nums[1][2]+nums[2][2];
//        }
//        while (l<nums.length){
//            if (i+1 < nums.length && nums[l][1] + nums[i][1] <= s) {
//                sum =nums[l][2] + nums[i+1][2];
//                i--;
//                value = Math.max(value,sum);
//            }
//        }
//        return value;
//    }
//}
