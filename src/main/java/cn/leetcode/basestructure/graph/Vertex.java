package cn.leetcode.basestructure.graph;

/**
 * dsc: Vertex 顶点类
 * date: 2020/11/23 11:06
 * author: zyc
 */
public class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char label){
        this.label = label;
        wasVisited = false;
    }
}
