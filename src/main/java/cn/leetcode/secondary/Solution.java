package cn.leetcode.secondary;

import java.util.HashMap;

/**
 * 两数之和：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 来源：力扣（LeetCode）
 *
 * @Author xiaoya.wen@raykite.com
 * @Date 2020/11/03  12:32
 **/
public class Solution {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
        int target = 6;
        int[] findArr = new int[2];

        findArr = mapFind(arr, target);
//        findArr = find(arr, target);

        System.out.println(findArr[0]);
        System.out.println(findArr[1]);
    }

    /**
     * 方法二：哈希解法（来源力扣）
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] mapFind(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) // 3-false，2-false，4-true
                return new int[]{map.get(nums[i]), i}; // 1-2

            map.put(target - nums[i], i); // 3-0，4-1
        }
        return null;
    }

    /**
     * 方法一：双重for循环
     *
     * @param arr
     * @param target
     * @return
     */
    public static int[] find(int[] arr, int target) {
        int[] indexs = new int[2];
        for (int i = 0; i < arr.length; i++) {
            indexs[0] = i;
            int num = arr[i];
            int partnerNum = target - num;
            for (int k = 0; k < arr.length; k++) {
                if (arr[k] == partnerNum && k != i) {
                    indexs[1] = k;
                    return indexs;
                }
            }
        }

        return null;
    }

    /**
     * 双重for循环，内层采用二分查找（有序数组）
     *
     * @param arr
     * @param left
     * @param right
     * @param data
     * @return
     */
    public static int find(int[] arr, int left, int right, int data) {
        int mid = (left + right) / 2;
        if (right <= left) {
            return -1;
        }
        if (data < arr[mid]) {
            return find(arr, left, mid - 1, data);
        } else if (data > arr[mid]) {
            return find(arr, mid + 1, right, data);
        } else {
            return mid;

        }
    }
}
