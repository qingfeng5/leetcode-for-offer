package leetcode;

/**
 * Created by 清风
 * 2020/5/10 11:00
 *
 * 面试题12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入这个格子。
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],
 * word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 */
public class S12_exist {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    // 当前元素在矩阵 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
     //   返回 falsefalse ： ① 行或列索引越界 或 ② 当前矩阵元素与目标字符不同
        //   或 ③ 当前矩阵元素已访问过 （③ 可合并至 ② ） 。
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0
                || board[i][j] != word[k])
            return false;
        //返回 true： 字符串 word 已全部匹配，即 k = len(word) - 1 。
        if(k == word.length - 1)
            return true;

        char tmp = board[i][j];
        //标记当前矩阵元素： 将 board[i][j] 值暂存于变量 tmp ，并修改为字符 '/' ，
        // 代表此元素已访问过，防止之后搜索时重复访问。
        board[i][j] = '/';
        //搜索下一单元格： 朝当前元素的 上、下、左、右 四个方向开启下层递归，
        // 使用 或 连接 （代表只需一条可行路径） ，并记录结果至 res 。
        //还原当前矩阵元素： 将 tmp 暂存值还原至 board[i][j] 元素。
        boolean res = dfs(board, word, i + 1, j, k + 1)
                || dfs(board, word, i - 1, j, k + 1)
                || dfs(board, word, i, j + 1, k + 1)
                || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }
}
