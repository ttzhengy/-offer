/*
从上到下打印二叉树
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
思路类似bfs
使用队列存放节点，将出队节点的不为空的节点入队
 */
public class JZ32_1 {
    public static void main(String[] args) {

    }
}

class JZ32_1Solution{
    public int[] levelOrder(TreeNode root) {
        if(root == null)return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null)queue.add(node.left);
            if(node.right != null)queue.add(node.right);
            list.add(node.val);
        }

        int size = list.size();
        int[] res = new int[size];
        for(int i=0;i<size;i++){
            res[i] = list.get(i);
        }

        return res;
    }
}