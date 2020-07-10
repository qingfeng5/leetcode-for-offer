package leetcode;

/**
 * Created by 清风
 * 2020/5/12 13:00
 * 面试题21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 */
public class S21_exchange {
    public int[] exchange(int[] nums) {
        //指针 i 从左向右寻找偶数；
        //指针 j 从右向左寻找奇数；
        int i = 0, j = nums.length - 1, tmp;
        //循环交换： 当 i =j 时跳出；
        while(i < j) {
            //x&1 位运算 等价于 x %2 取余运算，即皆可用于判断数字奇偶性。
            //指针 i 遇到奇数则执行 i = i + 1 跳过，直到找到偶数；
            while(i < j && (nums[i] & 1) == 1) i++;
            //指针 j 遇到偶数则执行 j = j - 1 跳过，直到找到奇数；
            while(i < j && (nums[j] & 1) == 0) j--;
            //上面只要有一个不成功就进行交换操作
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}
