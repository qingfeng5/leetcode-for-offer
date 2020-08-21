package leetcode_basic;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * Created by 清风
 * 2020/8/21 18:45
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class SL_64_minPathSum {
    // TODO: 2020/8/21  最小路径和 动态规划dp
    public int minPathSum(int[][] grid) {
        //走到当前单元格 (i,j) 的最小路径和
        // 等于“从左方单元格 (i-1,j) 与 从上方单元格 (i,j-1) 走来的 两个最小路径和中较小的 ” +当前单元格值 grid[i][j]

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                //当左边和上边都是矩阵边界时，就是起点
                if(i == 0 && j == 0) continue;
                //当只有左边是矩阵边界时： 只能从上面来
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];

                //当只有上边是矩阵边界时： 只能从左面来
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];

                //当左边和上边都是矩阵边界时：
                //从左方单元格 与 从上方单元格  走来的 两个最小路径和中较小的值 ” 跟相加 当前单元格值 grid[i][j]
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

}
