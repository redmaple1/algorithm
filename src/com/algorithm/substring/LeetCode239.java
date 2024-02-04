package com.algorithm.substring;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode239 {

    public static void main(String[] args) {
        int[] nums = {7,2,4};
        int k = 2;

        int[] res = maxSlidingWindow(nums, k);
        System.out.println(res);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        // 使用优先队列
        PriorityQueue<int[]>
                pq = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);

        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        int[] res = new int[n - k + 1];
        res[0] = pq.peek()[0];

        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k){
                pq.poll();
            }
            res[i - k + 1] = pq.peek()[0];
        }

        return res;

    }

}
