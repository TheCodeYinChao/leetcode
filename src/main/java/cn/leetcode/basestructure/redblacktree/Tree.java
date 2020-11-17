package cn.leetcode.basestructure.redblacktree;

/**
 * @author zyc
 * @date 2020/11/17
 * @time 22:41
 * @description :
 */
public class Tree {
    public static void main(String[] args) {
//        int [] array = {4,3,2,8,1,9,12,53};
//        int [] array = {4,3,2};
        int [] array = {4,9,10};
        Node root = new Node(array[0]);
        Tree t = new Tree();
        for (int i = 1; i < array.length; i++) {
            t.add(root,array[i]);
        }
        t.println(getroot(root));

    }

    public static Node getroot(Node node){
        Node parent = node.parent;
        if(parent== null){
            return node;
        }
        return getroot(parent);
    }

    /**
     * 前序
     */
    public void println(Node root){
        System.out.println(root.val);
        Node left = root.left;
        if(left != null){
            println(left);
        }
        Node right = root.right;
        if(right != null){
            println(right);
        }
    }


    public void add(Node node,int val){
        Node n = new Node(val);
        if(node.val > val){//左节点
            Node left = node.left;
            if(left == null){
                node.left = n;
                n.parent = node;
                if(val==2)
                rRotate(n);
            }else{
                add(left,val);
            }
        }
        if(node.val< val){//右节点
            Node right = node.right;
            if(right == null){
                node.right = n;
                n.parent = node;
                if(val==10)
                    lRotate(n);
            }else{
                add(right,val);
            }
        }
    }


    /**
     * 左旋
     * @param node
     */
    public void lRotate(Node node){
        Node parent1 = node.parent.parent;
        Node parent2 = parent1.parent;
        if(parent2 != null){
            node.parent.parent = parent2;
        }else {
            node.parent.parent = null;
        }
        parent1.right = null;
        parent1.parent = node.parent;
        node.parent.left = parent1;
    }

    /**
     * 右旋
     * @param node
     */
    public void rRotate(Node node){
        Node parent1 = node.parent.parent;
        Node parent2 = parent1.parent;
        if(parent2 != null){
            node.parent.parent = parent2;
        }else {
            node.parent.parent = null;
        }
        parent1.left = null;
        parent1.parent = node.parent;
        node.parent.right = parent1;
    }

    static class Node{
        Node left;
        Node right;
        int val;
        Node parent;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

}
