package cn.leetcode.difficulty;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * 来源：力扣（LeetCode）
 *
 * @Author xiaoya.wen@raykite.com
 * @Date 2020/11/09  19:00
 **/
public class FindTwoArray {
    public static void main(String[] args) {

        System.out.println(Integer.parseInt(null));
        int sum = 0;
        int n = 10;
        sum = (1 + n) * n / 2;
    }

    public static long fun1(long n){
        int result = 1;

        for (int i = 1; i < n; i++) {
            result*=i;
        }

        return result;
    }



    public static void merge(int[] arr1, int[] arr2) {
        int mid = (arr1.length + arr2.length) / 2;
        int mid1 = mid;
        if ((arr1.length + arr2.length) % 2 > 0) {
            mid1 += 1;
        }


    }

    public static void separete(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;

            separete(arr, left, mid, temp);
            separete(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int index = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
                i++;
                index++;
            } else {
                temp[index] = arr[j];
                j++;
                index++;
            }
        }

        while (i <= mid) {
            temp[index] = arr[j];
            j++;
            index++;
        }

        index = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[index];
            index++;
            tempLeft++;
        }
    }
}

class Node {

}