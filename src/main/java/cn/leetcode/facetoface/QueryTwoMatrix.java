package cn.leetcode.facetoface;

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
}
