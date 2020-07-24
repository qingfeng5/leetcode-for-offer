package leetcode;

import java.util.HashMap;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/7/16 21:19
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 */
public class S39_majorityElement_02 {
    /**HashMap方法：不是双百解法，但是容易理解，且普适性强，并考虑了数组中不存在满足条件的众数和数组为空的情况**/
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int length = nums.length/2;
        for(int i=0;i<nums.length;i++){
            //containsKey（key）方法是判断该key在map中是否有key存在。如果存在则返回true。如果不存在则返回false。
            if(map.containsKey(nums[i])) {
                //这里不能直接map.get(nums[i])++;
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
            //注意：这里if不能放在第一个if中，否则会在数组长度为1时出错，无法返回正确的nums[i]的值
            //这里i>=length，之所以带等号，也是为了满足长度为1的情况，因为i从0开始
            //按照题目要求，必须众数次数超过长度的一半，则有第一个判断条件，相当于剪枝，当然下面的第一个判断条件也可以不加
            if(i>=length&&map.get(nums[i])>length) return nums[i];
        }
        return 0;
        //当不存在满足要求的数字或者数组长度为0时
    }
}
