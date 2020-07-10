package leetcode;

/**
 * Created by 清风
 * 2020/5/9 9:16
 *面试题04. 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:*
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 *
 * 从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。
 * 如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行。
 */
public class S04_FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //从第一行最后一个元素开始往前开始推进，
        int rows = matrix.length, columns = matrix[0].length;
        //下面row = 0表示第一行，columns - 1最后一个元素
        int row = 0, column = columns - 1;
        //重复下列步骤，直到行下标或列下标超出边界
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            //如果 num 和 target 相等，返回 true
            if (num == target) {
                return true;
            } else if (num > target) {
                //如果 num 大于 target，列下标减 1
                column--;
            } else {
                //如果 num 小于 target，行下标加 1
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        System.out.println(new S04_FindNumberIn2DArray().findNumberIn2DArray(matrix,target));
    }
}
