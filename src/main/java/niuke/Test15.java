package niuke;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/9/2 14:33
 * The count-and-say sequence is the sequence of integers with the first five terms
 * as following:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * You can do so recursively, in other words from the previous member read off the digits,
 * counting the number of digits in groups of the same digit.
 * Note: Each term of the sequence of integers will be represented as a string.
 */
public class Test15 {
    public  int  num (int[] nums){
      int l= 0;
      int r = 0;
       int count = 0;
       int[] x = new int[30];
        for (int i = 0; i <x.length ; i++) {
            while (l<nums.length){
                if (nums.length<2){
                    return nums[l];
                }

                if (nums[l] == nums[r+1]){
                    count++;
                }
            }
        }

    }

}
