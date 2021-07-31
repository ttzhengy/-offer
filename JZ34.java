/*
二叉树中 和为某一值的路径
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
*/


import java.util.LinkedList;
import java.util.List;

/*
深度遍历
*/
public class JZ34 {
    public static void main(String[] args) {

    }
}

class JZ34Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root,target);
        return res;
    }

    public void recur(TreeNode root, int target){
        if(root == null)return;
        path.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)res.add(new LinkedList(path));
        recur(root.left, target);
        recur(root.right, target);
        path.removeLast();
    }
}