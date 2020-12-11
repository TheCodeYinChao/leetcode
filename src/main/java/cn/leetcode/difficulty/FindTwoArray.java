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
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * 来源：力扣（LeetCode）
 *
 * @Author xiaoya.wen@raykite.com
 * @Date 2020/11/09  19:00
 **/
public class FindTwoArray {
    public static void main(String[] args) {

        int[] nums1 = {};

        int[] nums2 = {3,4};

        System.out.println(merge(nums1,nums2));
    }

    public static double merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int mind = (m + n) / 2 + 1;
        int[] arr = new int[mind];
        int m1 = 0;
        int n1 = 0;
        for (int i = 0; i < mind; i++) {
            if (m <= 0) {
                arr[i] = nums2[n1];
                n--;
                n1++;
            } else if ( n <= 0) {
                arr[i] = nums1[m1];
                m--;
                m1++;
            } else if (nums1[m1] <= nums2[n1]) {
                arr[i] = nums1[m1];
                m--;
                m1++;
            } else {
                arr[i] = nums2[n1];
                n--;
                n1++;
            }
        }

        if ((m + n) % 2 == 0) {
            return (arr[mind - 1] + arr[mind - 2]) / 2d;
        } else {
            return arr[mind - 1];
        }

    }
}