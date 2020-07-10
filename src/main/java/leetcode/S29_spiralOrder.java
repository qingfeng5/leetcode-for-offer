package leetcode;

/**
 * Created by 清风
 * 2020/5/27 16:45
 * 面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
public class S29_spiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        //空值处理： 当 matrix 为空时，直接返回空列表 [] 即可。
        if(matrix.length == 0) return new int[0];
        //初始化： 矩阵 左、右、上、下 四个边界 l , r , t , b ，用于打印的结果列表 res
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        //循环打印： “从左向右、从上向下、从右向左、从下向上” 四个方向循环，每个方向打印中做以下三件事
        while(true) {
            //1、从左向右	边界打印 左边界l ，右边界 r
            for(int i = l; i <= r; i++)
                res[x++] = matrix[t][i]; // left to right.
            //1、上边界 t 加 1， 边界向内收缩
            if(++t > b) break;
            //2、从上向下	上边界 t ，下边界b
            for(int i = t; i <= b; i++)
                res[x++] = matrix[i][r]; // top to bottom.
            //2、右边界 r 减 1
            if(l > --r) break;
            //3、从右向左	右边界 r ，左边界l
            for(int i = r; i >= l; i--)
                res[x++] = matrix[b][i]; // right to left.
            //3、下边界 b 减 1
            if(t > --b) break;
            //4、从下向上	下边界 b ，上边界t
            for(int i = b; i >= t; i--)
                res[x++] = matrix[i][l]; // bottom to top.
            //左边界 l 加 1
            if(++l > r) break;
        }
        return res;
    }
}
