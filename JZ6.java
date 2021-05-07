/*
题目描述
从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */

/*
利用栈实现后进先出
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class JZ6 {
    public static void main(String[] args) {
        JZ6Solution jz6Solution = new JZ6Solution();
        int[] list = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            list[i] = random.nextInt();
        }
        JZ6Solution.ListNode head = jz6Solution.createNode(list);
        int[] arr = jz6Solution.reversePrint(head);
        System.out.println(Arrays.toString(arr));
    }
}

class JZ6Solution {
    Stack<Integer> stack = new Stack<>();
    
    public int[] reversePrint(ListNode head) {
        if (head!=null){
            ListNode temp = head;
            while (temp!=null){
                stack.push(temp.val);
                temp = temp.next;
            }
        }
        int size = stack.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode createNode(int[] arr){
        ListNode head = null;
        ListNode temp = null;
        for (int a : arr) {
            if (head==null){
                head=new ListNode(a);
            }else {
                if (head.next==null){
                    head.next = new ListNode(a);
                    temp = head.next;
                }else {
                    temp.next = new ListNode(a);
                    temp = temp.next;
                }
            }
        }
        return head;
    }
}