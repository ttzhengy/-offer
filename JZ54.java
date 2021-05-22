/*
二叉搜索树的第k大节点
 */

/*
用中序倒序遍历
用k记录当前遍历到的是第几大
 */
public class JZ54 {
}

class JZ54Solution {
    int k = 0, res = 0;
    public int kthLargest(TreeNode root, int k) {
        if (root==null || k==0)return 0;
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root){
        if (root==null)return;
        dfs(root.right);
        if (--k==0){
            res = root.val;
            return;
        }
        dfs(root.left);
    }
}