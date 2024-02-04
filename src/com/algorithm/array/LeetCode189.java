package com.algorithm.array;

import java.util.Arrays;

public class LeetCode189 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;

        int count = gcd(k ,n);
        for (int start = 0; start < count ; start++) {
            int current = start;
            int prev = nums[start];
            do{
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;

            }while (start != current);
        }
    }

    private static int gcd(int x, int y){
        return y > 0 ? gcd(y, x % y) : x;
    }

}
