package cn.leetcode.basestructure.redblacktree;

/**
 * dsc: BinaryTree 二叉树
 * date: 2020/11/19 11:18
 * author: zyc
 */
public class BinaryTree {

    public static void main(String[] args) {
        int [] array = {4,3,2,8,1,9,12,53};
//        int [] array = {4,3,2};
//        int [] array = {4,9,10};
        Node root = new Node(array[0]);
        for (int i = 1; i < array.length; i++) {
            add(root,array[i]);
        }
        println(root);
    }


    public static void add(Node node,int i){
        if(node.val > i){
            Node left = node.left;
            if(left == null){
                Node node1 = new Node(i);
                node1.val =i;
                node.left = node1;
                return;
            }
            add(node.left,i);
        }


        if(node.val < i){
            Node right = node.right;
            if(right == null){
                Node node1 = new Node(i);
                node1.val =i;
                node.right = node1;
                return;
            }
            add(node.right,i);
        }
    }

    /**
     * 前序
     */
    public static void println(Node root){
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
    static class Node{
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public static int leftH(Node node){
        if(node==null){
            return 0;
        }
        return getH(node.left);
    }

    public static int rightH(Node node){
        if(node==null){
            return 0;
        }
        return getH(node.right);
    }

    public  static int  getH(Node node){
        if(node==null){
            return 0;
        }
        int h = getH(node.left);
        int r = getH(node.right);
        return Math.max(h,r);
    }
}
