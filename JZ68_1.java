/*
二叉搜索树的最近公共祖先
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
*/

/*
迭代
若两指定节点值均大于/小于当前节点，即说明两指定节点在同侧子树
若当前节点等于其中一个节点的值，或两个节点在当前节点的两颗子树上，则当前节点即为最近公共祖先
 */
public class JZ68_1 {
    public static void main(String[] args) {

    }
}

class JZ68_1Solution{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;
        while(root != null){
            // 当前节点大于两指定节点，则向左子树
            if(root.val>p.val && root.val>q.val){
                root = root.left;
            // 当前节点大于两指定节点，则向左子树
            }else if(root.val<p.val && root.val<q.val){
                root = root.right;
            }else break;
        }
        return root;
    }
}