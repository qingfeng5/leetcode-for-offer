package leetcode_basic;

/**
 * Created by 清风
 * 2020/8/7 16:08
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *简单
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class SL226_invertTree {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        //递归中止条件
        //如果根节点为空的话，此时不需要做任何反转动作，直接返回空
        if(root == null)
            return null;

        //递归过程
        //先将左子树进行反转
        TreeNode left = invertTree(root.left);
        //再将右子数进行反转
        TreeNode right = invertTree(root.right);

        //交换一个左右孩子交换一个位置
        root.left = right;
        root.right = left;

        return root;
    }
}
