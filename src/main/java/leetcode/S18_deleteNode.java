package leetcode;

/**
 * Created by 清风
 * 2020/5/12 9:51
 * 面试题18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */
public class S18_deleteNode {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

    public ListNode deleteNode(ListNode head, int val) {
        //定位节点： 遍历链表，直到 head.val == val 时跳出，即可定位目标节点。
        //特例处理： 当应删除头节点 head 时，直接返回 head.next 即可。
        if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;

        // 当 cur 为空 或 cur 节点值等于 val 时跳出。
        while(cur != null && cur.val != val) {
            //保存当前节点索引，即 pre = cur 。
            pre = cur;
            //遍历下一节点，即 cur = cur.next
            cur = cur.next;
        }
        //删除节点： 若 cur 指向某节点，则执行 pre.next = cur.next 。
        // （若 cur 指向 nullnull ，代表链表中不包含值为 val 的节点。
        if(cur != null) pre.next = cur.next;
        return head;
    }

}
