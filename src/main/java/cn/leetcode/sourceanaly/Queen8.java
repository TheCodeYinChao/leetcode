package cn.leetcode.sourceanaly;

/**
 * 八皇后问题（回溯算法）
 *
 * @Author wenxiaoYa
 * @Date 2020/06/08  13:53
 **/
public class Queen8 {

    int[] arr = new int[8];

    int count = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.que(0);

        System.out.println("=====================");
        System.out.println(queen8.count);
    }

    public void que(int n) {
        if (n == arr.length) {
            foreach();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[n] = i;
            if (check(n)) {
                que(n + 1);
            }
        }

    }

    /**
     * 检查是否符合理：任意两个皇后都不能处于同一行、同一列、统一斜线上
     *
     * @param n
     * @return
     */
    public boolean check(int n) {
        for (int i = 0; i < n; i++) {
            /**
             * arr[i] == arr[n]：同一列
             * Math.abs(n - i) == Math.abs(arr[n] - arr[i])：同一斜线
             */
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public void foreach() {
        count++;
        for (int data : arr) {
            System.out.print(data + " ");
        }
        System.out.println();
    }
}
