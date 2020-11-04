package cn.leetcode.skiplist;

import org.junit.Test;

/**
 * @author zyc
 * @date 2020/11/3
 * @time 23:01
 * @description :
 * // 这里必须是 <=
    while (left <= right) {
         int mid = (left + right) / 2;
        if (array[mid] ? key) {
             //... right = mid - 1;
        }
        else {
             // ... left = mid + 1;
        }
    }
    return xxx;
 */
public class BinarySearch {
    @Test
    public void binaryS(){
        int[] array = {1, 3, 5};// {1,23,44,55,66,77,88};
        int target = 5;
        int left = 0;
        int right = array.length-1;
        int mid = 0;
        int rs = -1;

        while (left <= right){//注意这里必须<= 否则会出现最后一个找不到因为二分之后 left = right
            mid = (left+right)/2;
            if(array[mid] == target){
                rs = mid;
                break;
            }else if(array[mid] < target){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        System.out.println(rs);
    }

    //变种
    /**
     *查找第一个与key相等的元素
     */
    static int findFirstEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if (left < array.length && array[left] == key) {
            return left;
        }

        return -1;
    }

    // 查找最后一个相等的元素
    static int findLastEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] <= key) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if (right >= 0 && array[right] == key) {
            return right;
        }

        return -1;
    }

    // 查找最后一个等于或者小于key的元素
    static int findLastEqualSmaller(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return right;
    }

    // 查找最后一个小于key的元素
    static int findLastSmaller(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return right;
    }

    // 查找第一个等于或者大于key的元素
    static int findFirstEqualLarger(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 查找第一个大于key的元素
    static int findFirstLarger(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}
