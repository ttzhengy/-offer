/*
题目描述
包含min函数的栈
定义栈的数据结构，在该类型中实现一个能够得到栈的最小元素的min函数
在该栈中调用 min、push 及 pop 的时间复杂度都是O(1)
 */

/*
min的时间复杂度也是O(1)，即入栈出栈时同时也要更新当前的min值
因此需要把每次入栈时整个栈的最小值也用栈存放起来
 */
public class JZ30 {
    public static void main(String[] args) {
        JZ30MinStack minStack = new JZ30MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();
        minStack.pop();
        minStack.top();
        minStack.min();
    }
}

class JZ30MinStack {
    ListNode stackHead;
    ListNode minStackHead;
    int min;
    public JZ30MinStack() {
        stackHead = new ListNode(-1);
        minStackHead = new ListNode(-1);
    }

    public void push(int x) {
        ListNode node = new ListNode(x);
        if (stackHead.next==null){
            stackHead.next = node;
            minStackHead.next = node;
            min = x;
        }else {
            node.next = stackHead.next;
            stackHead.next = node;
            if (minStackHead.next==null || minStackHead.next.val >= x){
                ListNode min = new ListNode(x);
                min.next = minStackHead.next;
                minStackHead.next = min;
            }
        }
    }

    public void pop() {
        if (stackHead.next == null){
            return;
        }
        if (minStackHead.next.val == stackHead.next.val){
            minStackHead.next = minStackHead.next.next;
        }
        stackHead.next = stackHead.next.next;
    }

    public int top() {
        return stackHead.next.val;
    }

    public int min() {
        return minStackHead.next.val;
    }
}