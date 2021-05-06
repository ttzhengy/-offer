import java.util.*;

/*
题目描述
操作给定的二叉树，将其变换为源二叉树的镜像。
 */

/*
遍历所有节点，交换所有非叶子节点的左右子树
 */

public class JZ27 {
    public static void main(String[] args) {
        JZ27Solution jz27Solution = new JZ27Solution();
        JZ27Solution.TreeNode treeRoot = jz27Solution.createTreeRoot();
        jz27Solution.Mirror(treeRoot);
    }
}

class JZ27Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if (pRoot==null)return null;
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }

    public TreeNode createTreeRoot(){
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(11);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left= node5;
        node2.right=node6;

        return root;
    }

    class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }
}
