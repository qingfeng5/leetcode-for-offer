package leetcode;

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
public class S61_isStraight {
    public boolean isStraight(int[] nums) {
        //遍历五张牌，遇到大小王（即 00 ）直接跳过。
        //判别重复： 利用 Set 实现遍历判重， Set 的查找方法的时间复杂度为 O(1)O(1) ；
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if(repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }

}
