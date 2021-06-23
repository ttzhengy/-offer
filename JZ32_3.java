/*
从上到下打印二叉树
实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
*/

import java.util.*;

/*
使用双端队列deque实现，用一个标志位表示输出顺序
从左到右输出时，添加节点的顺序是先左节点后右节点
从右到左输出时，添加节点的顺序是先右节点后左节点
*/
public class JZ32_3 {
    public static void main(String[] args) {

    }
}

class JZ32_3Solution{
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null)deque.add(root);
        boolean flag = true;
        while(!deque.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            int size = deque.size();
            if(flag){
                for(int i=size;i>0;i--){
                    TreeNode node = deque.pollFirst();
                    if(node.left != null)deque.offerLast(node.left);
                    if(node.right != null)deque.offerLast(node.right);
                    arr.add(node.val);
                }
            }else{
                for(int i=size;i>0;i--){
                    TreeNode node = deque.pollLast();
                    if(node.right != null)deque.offerFirst(node.right);
                    if(node.left != null)deque.offerFirst(node.left);
                    arr.add(node.val);
                }
            }
            res.add(arr);
            flag = !flag;
        }
        return res;
    }
}