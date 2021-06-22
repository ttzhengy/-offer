/*
栈的压入、弹出序列
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
*/

import java.util.Stack;

/*
建立一个辅助栈来模拟压栈、出栈过程
入栈顺序：根据压栈序列依次进行
出栈顺序：每次入栈后，循环【判断栈顶元素是否与当前弹出序列元素——弹出——弹出序列索引+1】
 */
public class JZ31 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.peek());
    }
}

class JZ31Solution{
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for(int i:pushed){
            stack.push(i);
            while(!stack.isEmpty() && stack.peek()==popped[index]){
                stack.pop();
                index++;
            }
        }

        return stack.isEmpty();
    }
}