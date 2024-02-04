package com.algorithm.array;

public class LeetCode41 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, -1, 1};
        int res = firstMissingPositive(nums);
        System.out.println(res);
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 循环一遍数组，每一位交换到正确的位置
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
