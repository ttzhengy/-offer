/*
二叉树的最近公共祖先
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
*/

/*
递归
- 终止条件
    - root = null
    - root = p或q
- 递归返回值
    - 对左右节点递归，返回值分别即为left和right
- 递归方法体
    - 如果left，right均为null，说明节点不在root的子树中
    - 如果left，right中一个为null，另一个不为null，则说明节点在一侧子树，返回该侧节点
    - 如果left，right均不为null，说明p，q在当前节点的两侧子树，返回当前节点
 */
public class JZ68_2 {
    public static void main(String[] args) {

    }
}

class JZ68_2Solution{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == q || root == p)return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null && right == null)return null;
        if(left == null)return right;
        if(right == null)return left;
        return root;
    }
}
