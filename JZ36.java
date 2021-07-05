/*
二叉搜索树与双向链表
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
*/

/*
中序遍历，使用类变量
*/
public class JZ36 {
    public static void main(String[] args) {

    }
}

class JZ36Solution {

    // 辅助节点，前置节点和头结点
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if(root == null)return null;
        head = new Node();
        pre = head;
        midOrder(root);
        head.right.left = pre;
        pre.right = head.right;
        return head.right;
    }

    public void midOrder(Node node){
        if(node == null)return;
        midOrder(node.left);

        Node temp = new Node(node.val);
        pre.right = temp;
        temp.left = pre;
        pre = temp;

        midOrder(node.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}