/*
二叉树的深度
输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 */

/*
递归求左子树和右子树的深度，返回两子树中较大的深度+1
 */
public class JZ55_1 {
}

class JZ55_1Solution {
    public int maxDepth(TreeNode root) {
        if (root==null)return 0;
        int leftDepth = maxDepth(root.left);
        int rightDelth = maxDepth(root.right);
        return (leftDepth>rightDelth)?leftDepth+1:rightDelth+1;
    }
}