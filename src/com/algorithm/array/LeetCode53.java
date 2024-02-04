package com.algorithm.array;

public class LeetCode53 {

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,-1,7,8};
        int res = maxSubArray(nums);
        System.out.println(res);
    }

    public static int maxSubArray(int[] nums) {

        int len = nums.length;

        int res = Integer.MIN_VALUE;
        int minPreSum = 0;
        int preSum = 0;

        for (int i = 0; i < len; i++) {
            preSum += nums[i];
            res = Math.max(res, preSum - minPreSum);
            minPreSum = Math.min(minPreSum, preSum);
        }

        return res;
    }
}
