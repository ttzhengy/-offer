import java.util.Stack;

/*
两个栈模拟一个队列，
将stack1视作队列尾，往里面放入数据，
将stack2视作队列头，取出数据，
当stack2出完，才能将stack1中的数据弹出，压入到stack2
 */

public class JZ5 {
    public static void main(String[] args) {
        JZ5Solution queue = new JZ5Solution();
        for (int i = 0; i < 5; i++) {
            queue.push(i);
        }
        for (int i = 0; i < 5; i++) {
            queue.pop();
        }
    }
}

class JZ5Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()){
            throw new RuntimeException("empty");
        }else {
            return stack2.pop();
        }
    }
}
