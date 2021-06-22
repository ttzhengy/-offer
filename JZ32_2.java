/*
从上到下打印二叉树
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印，每一层打印到一行。
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
思路跟上一题基本一样
每一层的元素个数用queue.size()来判断
*/
public class JZ32_2 {
    public static void main(String[] args) {

    }
}

class JZ32_2Solution{
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null)queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i = queue.size();i>0;i--){
                TreeNode node = queue.poll();
                if(node.left != null)queue.add(node.left);
                if(node.right != null)queue.add(node.right);
                list.add(node.val);
            }
            res.add(list);
        }
        return res;
    }
}