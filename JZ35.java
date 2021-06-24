/*
复杂链表的复制
复制一个复杂链表。在复杂链表中，每个节点除了有一个next指针指向下一个节点，还有一个random指针指向链表中的任意节点或者 null。
*/


import java.util.HashMap;
import java.util.Map;

/*
做法一：哈希表
两次循环，用哈希表的映射关系，构建原节点和新节点的映射关系
做法二：拼接和拆分
三次循环，将新节点拼接在原节点后，构建了新节点的random指针指向后，再拆分成两个链表
*/
public class JZ35 {
    public static void main(String[] args) {

    }
}

class JZ35Solution{
    // 哈希表，用空间换时间
    public Node copyRandomListByMap(Node head) {
        if(head == null)return null;
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();

        // 第一次循环，新建节点，用哈希表保存<原节点-新节点>
        while(cur!=null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;

        // 第二次循环，将新建节点的next和random指向对应节点
        while(cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    // 拼接和拆分，三次循环
    public Node copyRandomList(Node head) {
        if(head == null)return null;
        Node cur = head;
        // 第一次，生成复制节点，拼接在原节点后
        while(cur != null){
            Node newCur = new Node(cur.val);
            newCur.next = cur.next;
            cur.next = newCur;
            cur = newCur.next;
        }
        cur = head;
        // 第二次，构建复制节点的random指针指向，注意random指针指向null
        while(cur != null){
            if(cur.random != null)cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        Node newHead = cur.next;
        Node newCur = newHead;
        // 第三次，将复制节点与原链表节点拆分
        while(newCur.next != null){
            cur.next = cur.next.next;
            newCur.next = newCur.next.next;
            cur = cur.next;
            newCur = newCur.next;
        }
        // 最后两个节点单独处理
        cur.next = null;
        newCur.next = null;
        return newHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}