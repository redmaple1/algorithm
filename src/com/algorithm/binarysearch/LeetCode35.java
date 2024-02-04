package com.algorithm.binarysearch;

public class LeetCode35 {

    public static void main(String[] args) {
        LeetCode35 handle = new LeetCode35();
        int[] nums = {1,3,5,6};
        int target = 2;
        int res = handle.searchInsert(nums, target);
        System.out.println(res);
    }

    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int l = 0, r = nums.length - 1;
        int mid = 0;
        while(l < r) {
            mid = (l + r) / 2;
            if(nums[mid] > target) {
                // 在左半部分
                r = mid - 1;
            } else if(nums[mid] < target) {
                // 在右半部分
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return mid;
    }

}
