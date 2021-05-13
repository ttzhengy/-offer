/*
题目描述
合并两个链表
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */

public class JZ25 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        new JZ25Solution().mergeTwoLists(l1,l2);
    }
}

class JZ25Solution{
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     if (l1 == null && l2 == null){
    //         return null;
    //     }
    //     if (l1 == null){
    //         return l2;
    //     }
    //     if (l2 == null) {
    //         return l1;
    //     }
    //
    //     ListNode mergeHead = new ListNode(-1);
    //     ListNode cur = mergeHead;
    //
    //     while (l1 != null && l2 != null){
    //         if (l1.val > l2.val){
    //             cur.next = l2;
    //             l2 = l2.next;
    //         }else {
    //             cur.next = l1;
    //             l1 = l1.next;
    //         }
    //         cur = cur.next;
    //     }
    //     cur.next = l1!=null?l1:l2;
    //     return mergeHead.next;
    // }

    // 递归做法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null){
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode mergeHead = null;

        if (l1.val > l2.val){
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1,l2.next);
        }else {
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next,l2);
        }

        return mergeHead;
    }
}
