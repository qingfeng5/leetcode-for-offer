package leetcode_basic;

/**
 * Created by 清风
 * 2020/7/26 17:37
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class SL1_twoSum {
    public int[] twoSum(int[] nums, int target) {

        if (nums.length < 2){
            throw new IllegalArgumentException("Illegal argument numbers");
        }
        int l=0;
        int r=nums.length-1;
        while (l < r){
            if ( nums[l] + nums[r] == target){
                int[] res ={l , r};
                return res;
            }
            else if (l<r && nums[l] + nums[r] <target ){
                l++;
            }
            else if(nums[l] + nums[r] > target) {
                r--;
            }

        }
        throw new IllegalArgumentException("Illegal argument numbers");

    }
}
