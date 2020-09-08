package leetcode_class.T04_maps;

import java.util.*;

/**
 * Created by 清风
 * 2020/9/7 22:09
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
public class SL_347_topKFrequent_02 {

    // TODO: 2020/9/7  前 K 个高频元素  快排

    //方法二：基于快速排序
    //思路与算法
    //
    //我们可以使用基于快速排序的方法，求出「出现次数数组」的前 k 大的值。
    //
    //在对数组arr[l…r] 做快速排序的过程中，我们首先将数组划分为两个部分arr[i…q−1] 与 arr[q+1…j]，
    // 并使得arr[i…q−1] 中的每一个值都不超过 arr[q]，且 arr[q+1…j] 中的每一个值都大于arr[q]。
    //
    //于是，我们根据 kk 与左侧子数组 arr[i…q−1] 的长度（为 q-iq−i）的大小关系：
    //
    //如果 k≤q−i，则数组arr[l…r] 前 kk 大的值，就等于子数组 arr[i…q−1] 前 k 大的值。
    //否则，数组 arr[l…r] 前 k 大的值，就等于左侧子数组全部元素，加上右侧子数组 arr[q+1…j] 中前k−(q−i) 大的值。

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        int[] ret = new int[k];
        qsort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            qsort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }

}
