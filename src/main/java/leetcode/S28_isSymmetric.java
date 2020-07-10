package leetcode;

/**
 * Created by 清风
 * 2020/5/21 10:12
 * 面试题28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3

 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class S28_isSymmetric {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        //若根节点 root 为空，则直接返回 true 。
        //返回值： 即 recur(root.left, root.right) ;
        return root == null ? true : recur(root.left, root.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        //当 L 和 R同时越过叶节点： 此树从顶至底的节点都对称，因此返回 true ；
        if(L == null && R == null) return true;
        //当 L 或 R 中只有一个越过叶节点： 此树不对称，因此返回 false ；
        //当节点 L 值 不等于 节点 R 值： 此树不对称，因此返回 false ；
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
