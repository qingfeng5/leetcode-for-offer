package leetcode_basic;

/**
 * Created by 清风
 * 2020/8/7 16:29
 * 100. 相同的树
 * 简单
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 */
public class SL100_isSameTree {


      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //当两棵树的当前节点都为 null 时返回 true
        if(p == null && q == null)
            return true;

        //当其中一个为 null 另一个不为 null 时返回 false
        if(p == null || q == null)
            return false;

        //当两个都不为空但是值不相等时，返回 false
        if(p.val != q.val)
            return false;

       // 执行过程：当满足终止条件时进行返回，不满足时分别判断左子树和右子树是否相同，
        // 其中要注意代码中的短路效应

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
