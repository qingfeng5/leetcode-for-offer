package leetcode_basic;

/**
 * Created by 清风
 * 2020/8/7 16:51
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class SL101_isSymmetric {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        //递归结束条件：
        //都为空指针则返回 true
        //只有一个为空则返回 false
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        //递归过程：
        //判断两个指针当前节点值是否相等
        //判断 A 的右子树与 B 的左子树是否对称
        //判断 A 的左子树与 B 的右子树是否对称
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

}
