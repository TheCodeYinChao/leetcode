package cn.leetcode.secondario;

/**
 * 两数相加：
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 * @Author xiaoya.wen@raykite.com
 * @Date 2020/11/04  19:58
 **/
public class TwoNumAdd {
//    static Node first;

    public static ListNode put(int data) {

        String dataString = data + "";
        dataString = new StringBuilder(dataString).reverse().toString();
        char[] chars = dataString.toCharArray();

        ListNode first = null;
        ListNode next = first;
        for (int i = 0; i < chars.length; i++) {
            if (first == null) {
                first = new ListNode(chars[i] - '0', null);
                next = first;
            } else {

                while (next.next != null) {
                    next = next.next;
                }
                next.next = new ListNode(chars[i] - '0', null);
            }
        }


        return first;
    }

    /**
     * 无法处理十位数相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode add(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        int sum = 0;
        int i = 10;
        if (l1 != null && l2 != null) {
            sum = l1.val + l2.val;

//            listNode = new ListNode(sum, null);
            for (; ; ) {
                if (l1.next != null && l2.next != null) {
                    int val = l1.next.val;
                    int val1 = l2.next.val;

                    val *= i;
                    val1 *= i;

                    sum = sum + val + val1;

                    i *= 10;

                    System.out.println(" node01.next != null && node02.next != null sum = " + sum);

                    l1 = l1.next;
                    l2 = l2.next;

                } else if (l1.next == null && l2.next != null) {
                    int val = l2.next.val;
                    val *= i;

                    sum = sum + val;

                    System.out.println("node02.next != null sum = " + sum);
                    i *= 10;

                    l2 = l2.next;

                } else if (l1.next != null && l2.next == null) {
                    int val = l1.next.val;
                    val *= i;

                    sum = sum + val;

                    System.out.println("node01.next != null sum = " + sum);
                    i *= 10;

                    l1 = l1.next;
                } else {
                    return put(sum);
                }

            }
        }

        return listNode;
    }

    /**
     * 来源leetcode评论解法 （无法处理十位数相加）
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return root.next;
    }


    public static void main(String[] args) {
//        ListNode node01 = put(9);
//        ListNode node02 = put(9999999991);
//        ListNode node02 = put(9999999991);

        ListNode node01 = new ListNode(9, null);
        ListNode node02 = new ListNode(9, null);
        node02.next = new ListNode(9, null);
        node02.next.next = new ListNode(9, null);
        node02.next.next.next = new ListNode(9, null);
        node02.next.next.next.next = new ListNode(9, null);
        node02.next.next.next.next.next = new ListNode(9, null);
        node02.next.next.next.next.next.next = new ListNode(9, null);
        node02.next.next.next.next.next.next.next = new ListNode(9, null);
        node02.next.next.next.next.next.next.next.next = new ListNode(1, null);
        node02.next.next.next.next.next.next.next.next.next = new ListNode(1, null);


        System.out.println(node01);
        System.out.println(node02);

        System.out.println(addTwoNumbers(node01, node02));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

//class Node {
//
//    int data;
//
//    Node next;
//
//    public Node(int data, Node next) {
//        this.data = data;
//        this.next = next;
//    }
//
//    @Override
//    public String toString() {
//        return "Node{" +
//                "data=" + data +
//                ", next=" + next +
//                '}';
//    }
//}