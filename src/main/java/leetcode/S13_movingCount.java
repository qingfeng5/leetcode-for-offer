package leetcode;

/**
 * Created by 清风
 * 2020/5/11 9:31
 *
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 *  示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 */
public class S13_movingCount {
    int m, n, k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }


    //s_{x+1} = s_x - 8，例如 19, 2019,20 的数位和分别为 10, 210,2 ；
    //根据数位和特点，矩阵中 满足数位和的解 构成的几何形状形如多个 等腰直角三角形 ，
    // 每个三角形的直角顶点位于 0, 10, 20, ...0,10,20,... 等数位和突变的矩阵索引处 。
    //三角形内的解虽然都满足数位和要求，但由于机器人每步只能走一个单元格，
    // 而三角形间不一定是连通的，因此机器人不一定能到达，称之为 不可达解 ；
    // 同理，可到达的解称为 可达解

    public int dfs(int i, int j, int si, int sj) {
        if(i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        // 根据可达解的结构，易推出机器人可 仅通过向右和向下移动，访问所有可达解 。
        //三角形内部： 全部连通，易证；
        //两三角形连通处： 若某三角形内的解为可达解，则必与其左边或上边的三角形连通（即相交），
        // 即机器人必可从左边或上边走进此三角形。

        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj)
                + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }
}
