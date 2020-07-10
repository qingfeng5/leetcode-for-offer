package leetcode;

/**
 * Created by 清风
 * 2020/5/12 9:34
 *
 * 面试题17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 */
public class S17_printNumbers {

    public int[] printNumbers(int n) {
        //求从1~pow(10,n)-1实际上可以转化为0-9在n个位置上的全排列
        int max = (int)Math.pow(10, n);
        int[] ans = new int[max - 1];
        for(int i = 1 ; i <= max - 1 ; i++){
            ans[i - 1] = i;
        }
        return ans;
    }
}
