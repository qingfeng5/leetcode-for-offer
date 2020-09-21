package leetcode_class.T06_list;

/**
 * Created by 清风
 * 2020/9/21 17:09
 * 中等
 * 面试题 02.05. 链表求和
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。

 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 *
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 */
public class SM_0205_addTwoNumbers_02 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        //保留List头
        ListNode result = head;
        //进位
        int carry = 0;
        int sum = 0;

        while (l1!= null || l2 != null) {
            sum = 0;
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }

            sum = sum + carry;
            carry = 0;

            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            }

            head.next = new ListNode(sum);
            head = head.next;
        }

        if (carry == 1) {
            head.next = new ListNode(1);
        }

        return result.next;
    }

}
