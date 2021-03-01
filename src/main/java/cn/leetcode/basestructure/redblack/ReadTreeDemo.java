package cn.leetcode.basestructure.redblack;

/**
 * @Author xiaoya.wen@raykite.com
 * @Date 2021/01/07  13:57
 **/
public class ReadTreeDemo {

    private static Node root;

    public static void main(String[] args) {
//        Node node = new Node(6);
        add(6);
        add(3);
        add(2);
        add(5);
        add(8);
        add(7);
        add(9);
        System.out.println(root);
        System.out.println("=========================");

//        rotateLeft(root);
//        System.out.println(root);
        rotateRight(root);
        System.out.println(root);
    }

    static class Node {
        boolean read;
        int data;
        Node left;
        Node right;
        Node parent;


        public Node(int data) {
            this.data = data;
            this.read = true;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "read=" + read +
                    ", data=" + data +
                    ", left=" + left +
                    ", right=" + right +
//                    ", parent=" + parent +
                    '}';
        }
    }

    /**
     * 添加
     *
     * @param val
     */
    public static void add(int val) {
        Node node = new Node(val);

        if (root == null) {
            root = node;
            return;
        }

        Node parent;
        Node newRoot = root;
        while (true) {
            parent = newRoot;
            if (val > newRoot.data) {
                newRoot = newRoot.right;
                if (newRoot == null) {
                    node.parent = parent;
                    parent.right = node;
                    break;
                }
            } else {
                newRoot = newRoot.left;
                if (newRoot == null) {
                    node.parent = parent;
                    parent.left = node;
                    break;
                }
            }
        }

//        root = parent;
    }

    public static boolean isReadBackTree(Node node) {
        Node left = node.left;
        Node right = node.right;
        boolean read = node.read;
        if (read) return false;

        for (; ; ) {
            if (left != null) {
            }
        }

    }

    /**
     * 改变颜色
     *
     * @param node
     */
    public static void changeColour(Node node) {
        Node parent = node.parent;
        parent.read = false;

    }

    /**
     * 左旋
     *
     * @param node
     */
    public static void rotateLeft(Node node) {

        Node right = node.right;    // 获取右节点

        node.right = right.left;    // 将右节点的左节点放到当前节点的右节点

        if (right.left != null) {
            right.left.parent = node;  // 将右节点的左节点的父节点改为当前节点
        }
        Node parent = node.parent;

        right.parent = parent;

        right.left = node;
        node.parent = right;    // 将当前节点的父节点改为右节点

        if (parent == null) { // node为根节点时，重置根节点
            root = right;
        }
    }

    /**
     * 右旋
     *
     * @param node
     */
    public static void rotateRight(Node node) {
        Node left = node.left;  // 获取左节点
        node.left = left.right; // 将左节点的右节点放到当前节点的左节点

        if (left.right != null) {
            left.right.parent = node;   // 将左节点的右节点的父节点改为当前节点
        }
        Node parent = node.parent;  // 获取当前节点的父节点
        left.parent = parent;   // 将左节点的父节点改为当前节点的父节点

        node.parent = left; // 将当前节点的父节点改为左节点
        left.right = node;  // 将左节点的右节点改为当前节点

        if (parent == null) {
            root = left;
        }
    }
}
