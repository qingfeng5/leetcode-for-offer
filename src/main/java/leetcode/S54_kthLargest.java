package leetcode;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/7/28 22:24
 * //剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 */

public class S54_kthLargest {
    //为求第 kk 个节点，需要实现以下 三项工作 ：
    //递归遍历时计数，统计当前节点的序号；
    //递归到第 kk 个节点时，应记录结果 resres ；
    //记录结果后，后续的遍历即失去意义，应提前终止（即返回）。
    //递归解析：
    //终止条件： 当节点 rootroot 为空（越过叶节点），则直接返回；
    //递归右子树： 即 dfs(root.right)dfs(root.right) ；
    //三项工作：
    //提前返回： 若 k = 0k=0 ，代表已找到目标节点，无需继续遍历，因此直接返回；
    //统计序号： 执行 k = k - 1k=k−1 （即从 kk 减至 00 ）；
    //记录结果： 若 k = 0k=0 ，代表当前节点为第 kk 大的节点，因此记录 res = root.valres=root.val ；

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }

    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }

}
