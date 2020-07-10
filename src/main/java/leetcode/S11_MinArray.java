package leetcode;

/**
 * Created by 清风
 * 2020/5/9 16:32
 *
 * 面试题11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 *  示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 *
 * 用左边位置 left 和中间位置 mid 的值进行比较是否可以？
 * 举例：[3, 4, 5, 1, 2] 与 [1, 2, 3, 4, 5] ，
 * 此时，中间位置的值都比左边大，但最小值一个在后面，一个在前面，因此这种做法不能有效地减治。
 *
 * 用右边位置 right 和中间位置 mid 的值进行比较是否可以？
 * 举例：[1, 2, 3, 4, 5]、[3, 4, 5, 1, 2]、[2, 3, 4, 5 ,1]，
 * 用右边位置和中间位置的元素比较，可以进一步缩小搜索的范围。
 *
 */
public class S11_MinArray {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        if (len == 0) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) {
                // [3, 4, 5, 1, 2]，mid 以及 mid 的左边一定不是最小数字
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else if (numbers[mid] == numbers[right]) {
                // 只能把 right 排除掉，下一轮搜索区间是 [left, right - 1]
                right = right - 1;
            } else {
                // 此时 numbers[mid] < numbers[right]
                // mid 的右边一定不是最小数字，mid 有可能是，下一轮搜索区间是 [left, mid]
                right = mid;
            }
        }

        // 最小数字一定在数组中，因此不用后处理
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] num ={3,4,5,1,2};
        System.out.println(new S11_MinArray().minArray(num));
    }
}

