package leetcode;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/7/16 21:15
 *
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 */
public class S66_constructArr {
    public int[] constructArr(int[] a) {
        if(a.length == 0) return new int[0];
        //初始化：数组 B ，其中 B[0] = 1；辅助变量 tmp = 1
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        //计算 B[i] 的 下三角 各元素的乘积，直接乘入 B[i] ；
        for(int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        //计算 B[i] 的 上三角 各元素的乘积，记为 tmp ，并乘入 B[i] ；
        for(int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
