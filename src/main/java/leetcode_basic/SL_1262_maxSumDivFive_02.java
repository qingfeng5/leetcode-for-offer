package leetcode_basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/8/20 19:52
 * 中等
 * 1262. 可被三整除的最大和
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * 示例 1：
 *
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 *
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 *
 */
public class SL_1262_maxSumDivFive_02 {

    // TODO: 2020/8/20 贪心
    public int maxSumDivThree(int[] nums) {
        //如果最后的累加和sum mod 3 ==1, 那我们可以有2种方式让其能够被33整除:
        //1.剔除一个数组中满足mod3==1，且近可能小的数
        //2.剔除两个数组中满足mod3==2，且近可能小的数
        List<Integer> one = new ArrayList<>(); // 存放 mod3=1 的数
        List<Integer> two = new ArrayList<>(); // 存放 mod3=2 的数

        int sum = 0;
        for (int e : nums) {
            if (e % 3 == 1) one.add(e);
            if (e % 3 == 2) two.add(e);
            sum += e;
        }

        Collections.sort(one);
        Collections.sort(two);

        int res = sum % 3, ans = 0;

        if (res == 0) return sum;

        if (res == 1) {
            //剔除一个满足mod3==1的数， 或两个满足mod3==2的数
            if (two.size() >= 2) ans = Math.max(ans, sum-two.get(0)-two.get(1));
            if (one.size() >= 1) ans = Math.max(ans, sum-one.get(0));

        } else if (res == 2) {
            //如果最后的累加和sum mod 3 == 2, 那我们可以有2种方式让其能够被3整除:
            //1.剔除一个数组中满足mod3==2，且近可能小的数
            //2.剔除两个数组中满足mod3==1，且近可能小的数

            //剔除一个满足mod3==2的数， 或两个满足mod3==1的数
            if (two.size() > 0) ans = Math.max(ans, sum-two.get(0));
            if (one.size() >= 2) ans = Math.max(ans, sum-one.get(0)-one.get(1));
        }
        return ans;

    }
}
