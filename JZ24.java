/*
题目描述
反转链表
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点
 */

/*
定义三个指针，做好边界测试
 */
public class JZ24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        JZ24Solution jz24 = new JZ24Solution();
        ListNode reverseHead = jz24.reverseList(head);
    }
}

class JZ24Solution{
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode node = head;
        ListNode next = head.next;
        ListNode pre = null;
        while (node!=null){
            node.next = pre;
            pre = node;
            node = next;
            if (next!=null){
                next = next.next;
            }
        }
        return pre;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int v){val=v;}
}