package leetcode;

import java.util.LinkedList;

/**
 * Created by 清风
 * 2020/5/8 16:26
 *
 * 面试题09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，
 * 请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )

 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 解题思路：
 * 栈无法实现队列功能： 栈底元素（对应队首元素）无法直接删除，需要将上方所有元素出栈。
 * 双栈可实现列表倒序： 设有含三个元素的栈 A = [1,2,3] 和空栈 B = []。
 * 若循环执行 AA 元素出栈并添加入栈 B ，直到栈 A 为空，则 A = [] , B = [3,2,1] ，
 * 即 栈 B 元素实现栈 A 元素倒序 。
 * 利用栈 B 删除队首元素： 倒序后，B 执行出栈则相当于删除了 A 的栈底元素，即对应队首元素。
 *

 */
public class S09_CQueue {

    LinkedList<Integer> A, B;
    public S09_CQueue() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }
    public void appendTail(int value) {
        A.addLast(value);
    }
    public int deleteHead() {
        if(!B.isEmpty()) return B.removeLast();
        if(A.isEmpty()) return -1;
        while(!A.isEmpty())
            B.addLast(A.removeLast());
        return B.removeLast();
    }
}
