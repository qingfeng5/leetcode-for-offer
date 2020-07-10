package leetcode;

/**
 * Created by 清风
 * 2020/5/16 15:00
 * 面试题22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，
 * 它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 */
public class S22_getKthFromEnd {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        //初始化： 前指针 former 、后指针 latter ，双指针都指向头节点 head​ 。
        ListNode former = head, latter = head;
        //构建双指针距离： 前指针 former 先向前走 k 步（
        // 结束后，双指针 former 和 latter 间相距 k 步）
        for(int i = 0; i < k; i++) {
            if(former == null) return null;
            former = former.next;
        }
        //双指针共同移动：
        // 循环中，双指针 former 和 latter 每轮都向前走一步，
        // 直至 former 走过链表 尾节点 时跳出
        //（跳出后， latter 与尾节点距离为 k-1，即 latter 指向倒数第 k个节点）。
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }


}
