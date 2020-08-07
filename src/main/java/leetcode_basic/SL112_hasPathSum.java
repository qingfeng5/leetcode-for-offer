package leetcode_basic;

/**
 * Created by 清风
 * 2020/8/7 16:58
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2
 */
public class SL112_hasPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {

        //递归中止条件，
        //如果左子树为空，node为空的时候忽视了上一层节点，就是父亲节点是否是叶子节点
        //如果不是父亲节点，也只有一个孩子的，也可能进入node为空的这个判断，产生错误代码
        if(root == null)
            return false;

        //那么就是如果左子树，并且右子数也为空的话，此时才会真正不会递归调用
        if(root.left == null && root.right == null)
            return sum == root.val;

        //递归条件
        //在root左子树中，去寻找一条路径，这个路径和应该是sum-当前root对应的value值
        //如果左子树没有，就去右子数，同理
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }
}
