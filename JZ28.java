/*
题目描述
对称的二叉树
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */


/*
用遍历的思想，对树从两端分别遍历比较

 */
public class JZ28 {
}

class JZ28Solution{
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }

    // 比较当前节点和左右子树
    // 需要比较n1的左子树与n2的右子树，n1的右子树与n2的左子树
    public boolean isSymmetric(TreeNode n1, TreeNode n2){
        if (n1==null && n2==null){
            return true;
        }
        if (n1==null || n2==null || n1.val!= n2.val){
            return false;
        }

        return isSymmetric(n1.left,n2.right)&&isSymmetric(n1.right,n2.left);
    }


}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val=x;}
}