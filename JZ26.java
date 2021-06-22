/*
树的子结构
输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
B是A的子结构， 即 A中有出现和B相同的结构和节点值。
*/

/*
先序遍历的同时，判断当前节点为根节点的子结构是否对应
 */
public class JZ26 {
    public static void main(String[] args) {

    }
}

class JZ26Solution{
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 若A节点为空，则返回false
        if(A==null || B==null)return false;
        // 判断当前子结构是否相同，不相同则往左右节点递归
        return recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    // 判断子结构函数
    boolean recur(TreeNode A, TreeNode B){
        // 若B（子结构）先被遍历完，则树中包含该子结构
        if(B==null)return true;
        // 若值不相同或者树中无对应节点，则返回false
        if(A==null || A.val != B.val)return false;
        // 当前节点相等，且尚未遍历完，则往左右节点递归
        return recur(A.left,B.left) && recur(A.right,B.right);
    }
}