package leetcode;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/7/16 20:58
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 */
public class S59_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int numLen = nums.length;
        if (numLen == 0) return new int[0];
        int[] ans = new int[numLen - k + 1]; // 保存结果
        int left = -1; // 左指针
        int right = k - 2; // 右指针
        int max = left; // 最大值指针  使用最大值指针max指向当前的最大值

        while (right < numLen - 1) {
            left++;
            right++;
            if (max < left) { // 更新最大值
                max = left;
                for (int i = left; i <= right; i++) {
                    max = nums[max] < nums[i] ? i : max;
                }
            }
            else
                max = nums[max] < nums[right] ? right : max; // 更新最大值
            ans[left] = nums[max];
        }
        return ans;
    }

}
