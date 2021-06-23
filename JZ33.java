/*
二叉搜索树的后序遍历序列
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果
如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
*/


/*
二叉搜索树的后序遍历数组是[左子树|右子树|根节点]的形式，且左子树都比根节点小，右子树都比根节点大
从根节点开始，递归对每个子树都判断是否符合以上形式
*/
public class JZ33 {
    public static void main(String[] args) {

    }
}

class JZ33Solution{
    public boolean verifyPostorder(int[] postorder) {

        return recur(postorder,0,postorder.length-1);
    }

    boolean recur(int[] arr,int i, int j){
        if(i>=j)return true;
        // p作为从前往后遍历的指针
        int p = i;
        // 根据左子树小于根节点，找到左子树
        while(arr[p] < arr[j])p++;
        // m是左右子树的分界，右子树的起始
        int m = p;
        // 根据右子树小于根节点，找到左子树
        while(arr[p] > arr[j])p++;
        return p==j && recur(arr,i,m-1) && recur(arr,m,j-1);
    }
}