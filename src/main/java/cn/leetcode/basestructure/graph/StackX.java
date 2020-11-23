package cn.leetcode.basestructure.graph;

/**
 * dsc: StackX
 * date: 2020/11/23 11:14
 * author: zyc
 */
public class StackX {
    private final int SIZE = 20;
    private int[] st;
    private int top;

    public StackX(){
        st = new int[SIZE];
        top = -1;
    }

    public void push(int j){
        st[++top] = j;
    }

    public int pop(){
        return st[top--];
    }

    public int peek(){
        return st[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

}
