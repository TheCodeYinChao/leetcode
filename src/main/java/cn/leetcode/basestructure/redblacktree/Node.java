package cn.leetcode.basestructure.redblacktree;

/**
 * dsc: Node
 * date: 2020/11/10 18:41
 * author: zyc
 */
public class Node {
//    Node parent;
    Node leftChild;
    Node rightChild;
    int val;
    public Node(Node parent, Node leftChild, Node rightChild,int val) {
        super();
//        this.parent = parent;
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

    //添加结点
    public void add(Node node) {
        if(node==null) {
            System.out.println("此结点为空，不可添加");
            return;
        }
        if(this.val>node.val) {
            if(this.leftChild==null) {
                this.leftChild=node;
            }else {
                this.leftChild.add(node);
            }
        }else {
            if(this.rightChild==null) {
                this.rightChild=node;
            }else {
                this.rightChild.add(node);
            }
        }
        if(this.rightHeigh()-this.leftHeigh()>1) {
            this.leftRotate();
        }
        if(this.leftHeigh()-this.rightHeigh()>1) {
            this.rightRotate();
        }
        //左子树高>右子树高===>右旋转
        if(this.leftHeigh()-this.rightHeigh()>1) {
            if(this.leftChild!=null&&this.leftChild.leftHeigh()<this.leftChild.rightHeigh()) {
                this.leftChild.leftRotate();
            }
            this.rightRotate();
        }
        //右子树高》左子树高---》左旋转
        if(this.rightHeigh()-this.leftHeigh()>1) {
            if(this.rightChild!=null&&this.rightChild.leftHeigh()>this.rightChild.rightHeigh()) {
                this.rightChild.rightRotate();
            }
            this.leftRotate();
        }
    }

    //计算左子树的高度
    public int leftHeigh() {
        if(leftChild==null) {
            return 0;
        }
        return leftChild.height();
    }
    //计算右子树的高度
    public int rightHeigh() {
        if(rightChild==null) {
            return 0;
        }
        return rightChild.height();
    }
    //计算结点的树高度
    public int height() {
        return Math.max(leftChild==null ? 0 : leftChild.height(), rightChild==null?0:rightChild.height())+1;
    }

    /**
     * 左旋
     */
    public void leftRotate() {
        //创建新节点
        Node node=new Node(this.val);
        //对新结点进行操作
        node.leftChild=this.leftChild;
        node.rightChild=this.rightChild.leftChild;
        //修改当前节点
        this.val=this.rightChild.val;
        this.rightChild=this.rightChild.rightChild;
        this.leftChild=node;
    }

    /**
     * 右旋
     */
    public void rightRotate() {
        //创建新节点
        Node node = new Node(this.val);
        //操作新节点
        node.leftChild=this.leftChild.rightChild;
        node.rightChild=this.rightChild;
        //修改当前节点
        this.val=this.rightChild.val;
        this.leftChild=this.leftChild.leftChild;
        this.rightChild=node;
    }
}
