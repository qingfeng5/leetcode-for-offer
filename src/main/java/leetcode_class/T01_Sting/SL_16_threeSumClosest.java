package leetcode_class.T01_Sting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/28 11:34
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 *
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class SL_16_threeSumClosest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //打印输出n行数组
        int x[] = new int[n];
        for (int i = 0; i < n; i++)
            x[i] = sc.nextInt();

        int target =sc.nextInt();
        int sum = new SL_16_threeSumClosest().threeSumClosest(x,target);
        System.out.println(sum);
    }
    // TODO: 2020/8/28 双指针 三数之和接近某个数
    public int threeSumClosest(int[] nums, int target) {
        //进行数组排序
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++) {
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                //Math.abs取绝对值
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }

}
