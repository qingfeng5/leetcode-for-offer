package leetcode;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/7/28 22:28
 *
 * 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class S55_1_maxDepth {
    //：后序遍历（DFS）
    //树的后序遍历 / 深度优先搜索往往利用 递归 或 栈 实现，本文使用递归实现。
    //关键点： 此树的深度和其左（右）子树的深度之间的关系。
    // 显然，此树的深度 等于 左子树的深度 与 右子树的深度 中的 最大值 +1+1 。

    //算法解析：
    //终止条件： 当 root​ 为空，说明已越过叶节点，因此返回 深度 00 。
    //递推工作： 本质上是对树做后序遍历。
    //计算节点 root​ 的 左子树的深度 ，即调用 maxDepth(root.left)；
    //计算节点 root​ 的 右子树的深度 ，即调用 maxDepth(root.right)；
    //返回值： 返回 此树的深度 ，即 max(maxDepth(root.left), maxDepth(root.right)) + 1。

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

        public int maxDepth(TreeNode root) {
            if(root == null) return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

}
