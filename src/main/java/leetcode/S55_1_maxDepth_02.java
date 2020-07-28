package leetcode;

import java.util.LinkedList;
import java.util.List;

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
public class S55_1_maxDepth_02 {
    //方法二：层序遍历（BFS）
    //树的层序遍历 / 广度优先搜索往往利用 队列 实现。
    //关键点： 每遍历一层，则计数器 +1+1 ，直到遍历完成，则可得到树的深度。
    //算法解析：
    //特例处理： 当 root​ 为空，直接返回 深度 00 。
    //初始化： 队列 queue （加入根节点 root ），计数器 res = 0。
    //循环遍历： 当 queue 为空时跳出。
    //初始化一个空列表 tmp ，用于临时存储下一层节点；
    //遍历队列： 遍历 queue 中的各节点 node ，并将其左子节点和右子节点加入 tmp；
    //更新队列： 执行 queue = tmp ，将下一层节点赋值给 queue；
    //统计层数： 执行 res += 1 ，代表层数加 11；
    //返回值： 返回 res 即可。


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        List<TreeNode> queue = new LinkedList<>() {{ add(root); }}, tmp;
        int res = 0;
        while(!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for(TreeNode node : queue) {
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }

}
