package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/7/23 22:05
 *
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
 * 可以看成任意数字。A 不能视为 14。
 *简单
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 除大小王外，所有牌 无重复 ；
 * 设此 55 张牌中最大的牌为 maxmax ，最小的牌为 minmin （大小王除外），则需满足：
 * max - min < 5
 * max−min<5
 */
public class S61_isStraight_02 {
    public boolean isStraight(int[] nums) {
        //先对数组执行排序。
        //判别重复： 排序数组中的相同元素位置相邻，因此可通过遍历数组，
        // 判断 nums[i] = nums[i + 1]nums[i]=nums[i+1] 是否成立来判重。
        //获取最大 / 最小的牌： 排序后，数组末位元素 nums[4]nums[4] 为最大牌；
        // 元素 nums[joker]nums[joker] 为最小牌，其中 jokerjoker 为大小王的数量。

        int joker = 0;
        Arrays.sort(nums); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) joker++; // 统计大小王数量
            else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}
