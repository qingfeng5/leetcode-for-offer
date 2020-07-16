package leetcode;

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
public class S39_majorityElement {
    public int majorityElement(int[] nums) {
        //初始化： 票数统计 votes = 0， 众数 xx；
        int x = 0, votes = 0;
        ///循环抵消： 遍历数组 nums 中的每个数字 num；
        for(int num : nums){
            //当 票数 votes等于 0 ，则假设 当前数字 num为 众数 x ；
            if(votes == 0) x = num;
            //当 num = x时，票数 votes自增 1 ；否则，票数 votes 自减 1 。
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
