package com.algorithm.substring;

import java.util.HashMap;
import java.util.Map;

public class LeetCode560 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;

        int res = subarraySum(nums, k);
        System.out.println(res);
    }

    public static int subarraySum(int[] nums, int k) {
        // 本题使用前缀和 + 哈希表 来实现

        int pre = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)){
                res += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return res;
    }
}
