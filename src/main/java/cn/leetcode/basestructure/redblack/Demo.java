package cn.leetcode.basestructure.redblack;

/**
 * dsc: Demo
 * date: 2020/12/18 18:34
 * author: zyc
 */
public class Demo {
    public static void main(String[] args) {
        int[] i = {10,5,9,3,6,7,19,32,24,17};
        TreeNode root = new TreeNode();
        for (int i1 = 0; i1 < i.length; i1++) {
            int e = i[i1];
            root = root.add(root,e);
        }
        System.out.println(root);
    }
}
