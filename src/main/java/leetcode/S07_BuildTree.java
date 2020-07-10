package leetcode;

import java.util.Stack;

/**
 * 面试题07. 重建二叉树
 * Created by 清风
 * 2020/5/8 15:16
 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 例如，给出

     前序遍历 preorder = [3,9,20,15,7]
     中序遍历 inorder = [9,3,*,20,7]
     返回如下的二叉树：
      3
     /  \
     9   20
        /   \
        15   7

 列如
             3
            /   \
           9    20
         /     /  \
        8     15   7
       / \
      5  10
     /
    4
 preorder = [3,9,8,5,4,10,20,15,7]
 inorder = [4,5,8,10,9,3,15,20,7]
 前序遍历的第一个元素 3 是根节点，第二个元素 9 可能位于左子树或者右子树，需要通过中序遍历判断。

 中序遍历的第一个元素是 4 ，不是根节点 3，说明 9 位于左子树，因为根节点不是中序遍历中的第一个节点。
 同理，前序遍历的后几个元素 8、5、4 也都位于左子树，且每个节点都是其上一个节点的左子节点。

 前序遍历到元素 4，和中序遍历的第一个元素相等，说明前序遍历的下一个元素 10 位于右子树。
 那么 10 位于哪个元素的右子树？从前序遍历看，10 可能位于 4、5、8、9、3 这些元素中任何一个元素的右子树。
 从中序遍历看，10 在 8 的后面，因此 10 位于 8 的右子树。
 把前序遍历的顺序反转，则在 10 之前的元素是 4、5、8、9、3，其中 8 是最后一次相等的节点，
 因此前序遍历的下一个元素位于中序遍历中最后一次相等的节点的右子树。

 同理可知，20 位于 3 的右子树，15 和 7 分别是 20 的左右子节点。

 */
public class S07_BuildTree {


      public class TreeNode {
         int val;
        TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        //使用前序遍历的第一个元素创建根节点。
        TreeNode root = new TreeNode(preorder[0]);
        int length = preorder.length;
        //创建一个栈，将根节点压入栈内。
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        //初始化中序遍历下标为 0
        int inorderIndex = 0;

        //遍历前序遍历的每个元素，判断其上一个元素（即栈顶元素）是否等于中序遍历下标指向的元素。
        for (int i = 1; i < length; i++) {
            int preorderVal = preorder[i];
            TreeNode node =  stack.peek();
            //若上一个元素不等于中序遍历下标指向的元素，
            // 则将当前元素作为其上一个元素的左子节点，并将当前元素压入栈内。
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                //若上一个元素等于中序遍历下标指向的元素，则从栈内弹出一个元素，
                // 同时令中序遍历下标指向下一个元素，之后继续判断栈顶元素是否等于中序遍历下标指向的元素，
                // 若相等则重复该操作，直至栈为空或者元素不相等。然后令当前元素为最后一个想等元素的右节点。
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
