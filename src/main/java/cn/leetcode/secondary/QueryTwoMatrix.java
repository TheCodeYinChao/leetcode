package cn.leetcode.secondary;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 *
 * @Author xiaoya.wen@raykite.com
 * @Date 2020/12/29  16:01
 **/
public class QueryTwoMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length-1;

        return check(matrix, target, m);
    }

    /**
     * 该写法 采用二分查找法
     *
     * @param matrix
     * @param target
     * @param m
     * @return
     */
    public boolean check(int[][] matrix, int target, int m) {

        if (m < 0) return false;

        int[] arr = matrix[m];
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == arr[mid]) {
                return true;
            }
            if (target < arr[mid]) {
                high = mid - 1;
            }
            if (target > arr[mid]) {
                low = mid + 1;
            }

        }
        m--;
        return check(matrix, target, m);
    }

    /**
     * 背包问题：
     * 背包问题也是计算机中的经典问题。在最简单的形式中，包括试图将不同重量的数据项放到背包中，以使得背包最后达到指定的总重量。
     * <p>
     * 　　比如：假设想要让背包精确地承重20磅，并且有 5 个可以放入的数据项，它们的重量分别是 11 磅，8 磅，7 磅，6 磅，5 磅。计算哪几个数据项可以精确放入背包中。
     * <p>
     * 思路：
     * 1.数据项建立在有序数组上。
     * 2.从第-项开始，挨个往后加，如果相加数大于背包承重，则去掉第 n+1 项的重量，接着往后加，直到符合背包承重，或者第一项于任何重量都不符合背包承重。
     * 3.不符合，便从第二项开始，以此内推。
     *
     * @Author xiaoya.wen@raykite.com
     * @Date 2020/11/03  09:30
     **/
    public static class PackageDemo {
        //        static int[] arr = {1, 6, 7, 9, 10};
    //    static int[] arr = {5, 6, 7, 8, 11};
        static int[] arr = {5, 7, 9, 88, 97, 99};
        //    static int[] arr = {5, 7, 9, 99, 100};
        static int[] addArr = new int[arr.length];
        static int sum = 0;
        static int addArrIndex = 0;

        public static void add(int index, int data) {

            if (index == addArr.length) {
                return;
            }
            addArrIndex = index;
            for (int i = index; i < arr.length; i++) {
                int num = arr[i];
                if (num + sum == data) {
                    addArr[i] = num;
                    return;
                } else if (num + sum < data) {
                    addArr[i] = num;
                    sum = sum + num;
                } else {
                    addArrIndex++;
                    sum = sum - addArr[addArrIndex];
                    i--;
                    addArr[addArrIndex] = 0;

                }

            }

            addArr = new int[arr.length];
            sum = 0;
            add(index + 1, data);
        }

        public static void main(String[] args) {
    //        test(20);
            add(0, 106);
            foreach();
        }

        public static void foreach() {
            for (int i = 0; i < addArr.length; i++) {
                System.out.println(addArr[i]);
            }
        }
    }
}
