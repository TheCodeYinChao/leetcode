package cn.leetcode.simple;

/**
 * 有序单向链表demo
 *
 * @Author xiaoya.wen@raykite.com
 * @Date 2020/12/15  18:39
 **/
public class SortSingLinkedDemo {

    public static void main(String[] args) {
        SingLinkedNode singLinkedNode = new SingLinkedNode(1, "zhangsan", null);
        SingLinkedNode singLinkedNode1 = new SingLinkedNode(2, "lisi", null);
        SingLinkedNode singLinkedNode2 = new SingLinkedNode(3, "wangwu", null);
        SingLinkedNode singLinkedNode3 = new SingLinkedNode(4, "liliu", null);

        SingLinkedNodeCenter sortSingLinkedDemo = new SingLinkedNodeCenter();
//        sortSingLinkedDemo.addNode(singLinkedNode);
//        sortSingLinkedDemo.addNode(singLinkedNode1);
//        sortSingLinkedDemo.addNode(singLinkedNode2);
//        sortSingLinkedDemo.addNode(singLinkedNode3);
        sortSingLinkedDemo.addNodeSort(singLinkedNode3);
        sortSingLinkedDemo.addNodeSort(singLinkedNode);
        sortSingLinkedDemo.addNodeSort(singLinkedNode1);
        sortSingLinkedDemo.addNodeSort(singLinkedNode2);

        System.out.println(sortSingLinkedDemo.head);
    }

}

class SingLinkedNodeCenter {
    public SingLinkedNode head;

    public void addNode(SingLinkedNode data) {
        if (head == null) {
            head = data;
            return;
        }

        SingLinkedNode next = head;
        while (next.getNext() != null) {
            next = next.getNext();
        }

        next.setNext(data);
    }

    public void addNodeSort(SingLinkedNode data) {
        if (head == null) {
            head = data;
            return;
        }

        SingLinkedNode next = head;
        if (next.getId() > data.getId()) {
            data.setNext(next);
            head = data;
            return;
        }

        while (next.getNext() != null) {
            if (next.getNext().getId() > data.getId()) {
                data.setNext(next.getNext());
                break;
            }
            next = next.getNext();
        }

        next.setNext(data);

    }
}

class SingLinkedNode {

    private int id;
    private String name;
    private SingLinkedNode next;

    public SingLinkedNode(int id, String name, SingLinkedNode next) {
        this.id = id;
        this.name = name;
        this.next = next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SingLinkedNode getNext() {
        return next;
    }

    public void setNext(SingLinkedNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "SingLinkedNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}
