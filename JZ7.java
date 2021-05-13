/*
题目描述
重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */

/*
使用栈迭代。根据前序压栈，栈顶当前作为根节点，辅助指针指向中序
当栈顶与辅助指针指向的值相同时，代表栈顶没有左子树，则返回祖先节点添加右子树
 */
import java.util.Stack;

public class JZ7  {
}

class JZ7Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0){
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        int inorderIndex = 0;
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]){
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            }else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]){
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorder[i]);
                stack.push(node.right);
            }
        }
        return root;
    }

}