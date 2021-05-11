import java.util.Stack;
/*
题目描述
链表中倒数第k个节点
输入一个链表，输出该链表中倒数第k个节点
为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 */

/*
使用快慢指针
同时注意边界条件，考虑代码鲁棒性
 */
public class JZ22 {
    public static void main(String[] args) {
        JZ22Solution jz22 = new JZ22Solution();
        JZ22Solution.ListNode head = jz22.new ListNode(1);
        JZ22Solution.ListNode n1 = jz22.new ListNode(2);
        JZ22Solution.ListNode n2 = jz22.new ListNode(3);
        head.next = n1;
        n1.next = n2;
        JZ22Solution.ListNode kthFromEnd = jz22.getKthFromEnd(head, 1);
    }
}


class JZ22Solution {
    // 用栈，约等于作弊
    // public ListNode getKthFromEnd(ListNode head, int k) {
    //     if (head == null) {
    //         return null;
    //     }
    //     Stack<ListNode> stack = new Stack<>();
    //     ListNode node = head;
    //     while (node!=null){
    //         stack.push(node);
    //         node = node.next;
    //     }
    //     for (int i = 1; i < k; i++) {
    //         stack.pop();
    //     }
    //     return stack.pop();
    // }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k==0){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int temp = k-1;
        while (fast!=null){
            fast = fast.next;
            if (k!=0){
                k--;
            }else {
                slow = slow.next;
            }
        }
        if (k!=0){
            return null;
        }else {
            return slow;
        }
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
}