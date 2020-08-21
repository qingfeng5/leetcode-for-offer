package niuke;


import java.util.Stack;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/8/20 19:34
 * 判断回文链表
 */
public class S08_isPalindrome {
    /**
     * 判断是否为回文链表
     * @param head ListNode类 链表头
     * @return bool布尔型
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public  boolean isPalindrome (ListNode head) {
        // write code here
        Stack<ListNode> stack =new Stack<ListNode>();
        ListNode cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null){
            if (head.next != stack.pop().next){
                return false;
            }
            head = head.next;
        }
        return  true;
    }
}
