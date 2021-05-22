/*
判断平衡二叉树
 */

/*
后序遍历的思路，从底到顶递归求解深度，并剪枝
对每个节点：
- 节点为空，即越过叶节点，返回0
- 节点值为左右子树中深度较大值+1
- 如果左右子树深度差值绝对值大于1，则返回-1
- 递归过程中，如果某个子树返回值为-1，则直接返回-1
 */
public class JZ55_2 {
}

class JZ55_2Solution {
    public boolean isBalanced(TreeNode root) {
        return recur(root)!=-1;
    }

    public int recur(TreeNode root){
        if (root==null)return 0;
        int left = recur(root.left);
        if (left==-1)return -1;
        int right = recur(root.right);
        if (right==-1)return -1;
        return Math.abs(left-right)<2?Math.max(left,right)+1:-1;
    }
}