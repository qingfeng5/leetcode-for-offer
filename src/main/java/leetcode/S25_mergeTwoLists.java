package leetcode;

/**
 * Created by 清风
 * 2020/5/16 15:44
 * 面试题25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class S25_mergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //初始化： 伪头节点 dum ，节点 cur 指向 dum 。
        ListNode dum = new ListNode(0), cur = dum;
        //循环合并： 当 l_1或 l_2为空时跳出；
        while(l1 != null && l2 != null) {
            //当 l_1.val < l_2.val，cur 的后继节点指定为 l_1，l_1向前走一步；
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                // //当 l_1.val >= l_2.val，cur 的后继节点指定为 l_2，l_2向前走一步；
                cur.next = l2;
                l2 = l2.next;
            }
            //节点 cur 向前走一步，即 cur = cur.next
            cur = cur.next;
        }
        //合并剩余尾部： 跳出时有两种情况，即 l_1为空 或 l_2为空。
        //若 l_1 不为null ： 将 l_1添加至节点 cur 之后；
        // 否则： 将 l_2添加至节点 curcur 之后。
        cur.next = l1 != null ? l1 : l2;
        //返回值： 合并链表在伪头节点 dum 之后，因此返回 dum.next 即可。
        return dum.next;
    }
}
