/*
输入两个链表，找出它们的第一个公共节点。
 */

/*
假设链表A长为a，链表B长为b，公共部分长为c
指针nodeA从链表A的头部开始遍历到尾部，再从链表B的头部遍历到公共节点，经过长度为a+(b-c)
指针nodeB从链表B的头部开始遍历到尾部，再从链表A的头部遍历到公共节点，经过长度为b+(a-c)
都走过a+b-c到达公共节点
如果没有公共节点，两个指针走过a+b，都指向null
 */
import java.util.Stack;

public class JZ52 {
}

class JZ52Solution {

    // 这个方法是找到第一个数值相同的节点，但不是完全相同的节点
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode temp = headA;
        while (temp.next!=null){
            stack1.add(temp);
            temp = temp.next;
        }
        stack1.add(temp);
        temp = headB;
        while (temp.next!=null){
            stack2.add(temp);
            temp = temp.next;
        }
        stack2.add(temp);

        ListNode temp2 = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            ListNode pop1 = stack1.pop();
            ListNode pop2 = stack2.pop();
            if (pop1.val== pop2.val){
                pop1.next = temp2;
                temp2 = pop1;
            }else {
                return temp2;
            }
        }
        return temp2;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode A = headA,B = headB;
        while (A!=B){
            A=A!=null?A.next:headB;
            B=B!=null?B.next:headA;
        }
        return A;
    }
}