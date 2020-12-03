package cn.leetcode.basestructure.balancetree;

import java.util.Stack;

/**
 * dsc: BalanceTwoTree 平衡二叉树
 * 形成条件
 *  1 左右两个子树的高度差的绝对值不超过1
 *  2 并且左右两个子树都是一棵平衡二叉树
 * 复杂度
 *  插入，查找，删除的时间复杂度最好情况和最坏情况都维持在O(logN)
 *  ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
 *  还得琢磨琢磨
 * date: 2020/11/10 16:39
 * author: zyc
 */
public class BalanceTwoTree {
    public static void main(String[] args) {
//        int [] array = {4,3,2,8,1,9,12,53};
        int [] array = {3,4,5,6,7,8};
        BalanceTwoTree b = new BalanceTwoTree();
        Node node =new Node(array[0]);
        for (int i = 1; i < array.length; i++) {
            node.add(new Node(array[i]));
        }


        preOrderRe(node);
        System.out.println("-----------------");
//
//        midOrderRe(b.root);
//        System.out.println("-----------------");
//
//        postOrderRe(b.root);

    }

    private Node root;

    public void put(int val){
        if(root == null){
            root = new Node(val);
            return;
        }
        insert(root,val);
    }



    /**插入节点*/
    public Node insert(Node nobde,int val){
        Node node = new Node(val);
        if(nobde.val > val){//左边
            Node leftChild = nobde.leftChild;
            if(leftChild == null){
                nobde.leftChild = node;
                node.parent = nobde.leftChild;
                return node;
            }else {
                insert(nobde.leftChild,val);
            }
        }
        if(nobde.val < val){//右边边

            Node rightChild = nobde.rightChild;
            if(rightChild == null){
                nobde.rightChild = node;
                node.parent = nobde.rightChild;
                return node;
            }else {
                insert(nobde.rightChild,val);
            }
        }
        return null;
    }


    /**
     * 左旋
     */


    /**
     * 右旋
     */
    public void rRotate(){



    }






    /**前序遍历 start */
    public static void preOrderRe(Node biTree)
    {//递归实现
        System.out.println(biTree.val);
        Node leftTree = biTree.leftChild;
        if(leftTree != null)
        {
            preOrderRe(leftTree);
        }
        Node rightTree = biTree.rightChild;
        if(rightTree != null)
        {
            preOrderRe(rightTree);
        }
    }

    public static void preOrder(Node biTree)
    {//非递归实现
        Stack<Node> stack = new Stack<Node>();
        while(biTree != null || !stack.isEmpty())
        {
            while(biTree != null)
            {
                System.out.println(biTree.val);
                stack.push(biTree);
                biTree = biTree.leftChild;
            }
            if(!stack.isEmpty())
            {
                biTree = stack.pop();
                biTree = biTree.rightChild;
            }
        }
    }
    /**前序遍历 end */


    /**中序遍历 start*/
    public static void midOrderRe(Node biTree)
    {//中序遍历递归实现
        if(biTree == null)
            return;
        else
        {
            midOrderRe(biTree.leftChild);
            System.out.println(biTree.val);
            midOrderRe(biTree.rightChild);
        }
    }


    public static void midOrder(Node biTree)
    {//中序遍历费递归实现
        Stack<Node> stack = new Stack<Node>();
        while(biTree != null || !stack.isEmpty())
        {
            while(biTree != null)
            {
                stack.push(biTree);
                biTree = biTree.leftChild;
            }
            if(!stack.isEmpty())
            {
                biTree = stack.pop();
                System.out.println(biTree.val);
                biTree = biTree.rightChild;
            }
        }
    }
    /**中序遍历 end*/


    /**后序遍历 start*/
    public static void postOrderRe(Node biTree)
    {//后序遍历递归实现
        if(biTree == null)
            return;
        else
        {
            postOrderRe(biTree.leftChild);
            postOrderRe(biTree.rightChild);
            System.out.println(biTree.val);
        }
    }

    public static void postOrder(Node biTree)
    {//后序遍历非递归实现
        int left = 1;//在辅助栈里表示左节点
        int right = 2;//在辅助栈里表示右节点
        Stack<Node> stack = new Stack<Node>();
        Stack<Integer> stack2 = new Stack<Integer>();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点。

        while(biTree != null || !stack.empty())
        {
            while(biTree != null)
            {//将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(biTree);
                stack2.push(left);
                biTree = biTree.leftChild;
            }

            while(!stack.empty() && stack2.peek() == right)
            {//如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                System.out.println(stack.pop().val);
            }

            if(!stack.empty() && stack2.peek() == left)
            {//如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                biTree = stack.peek().rightChild;
            }

        }
    }
    /**后序遍历 end*/

}

