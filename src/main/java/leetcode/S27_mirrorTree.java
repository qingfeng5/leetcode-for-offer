package leetcode;

/**
 * Created by 清风
 * 2020/5/21 9:48
 * 面试题27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 镜像输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */
public class S27_mirrorTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mirrorTree(TreeNode root) {
        // 当节点 root 为空时（即越过叶节点），则返回 nullnull ；
        if(root == null) return null;
        //初始化节点 tmp ，用于暂存 root 的左子节点；
        TreeNode tmp = root.left;
        //开启递归 右子节点 mirrorTree(root.right) ，并将返回值作为 root 的左子节点 。
        root.left = mirrorTree(root.right);
        //开启递归 左子节点 mirrorTree(tmp) ，并将返回值作为 root的 右子节点 。
        root.right = mirrorTree(tmp);
        return root;
    }
}
