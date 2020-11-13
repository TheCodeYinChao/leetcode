package cn.leetcode.basestructure.redblacktree;

/**
 * dsc: Node
 * date: 2020/11/10 18:41
 * author: zyc
 */
public class Node {
    Node parent;
    Node leftChild;
    Node rightChild;
    int val;
    public Node(Node parent, Node leftChild, Node rightChild,int val) {
        super();
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.val = val;
    }

    public Node(int val){
        this(null,null,null,val);
    }

    public Node(Node node,int val){
        this(node,null,null,val);
    }
}
