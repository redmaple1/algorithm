package com.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        LeetCode78 handle = new LeetCode78();
        List<List<Integer>> res = handle.subsets(nums);
        System.out.println(res);
    }

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int cur) {
        if(cur == nums.length) {
            res.add(new ArrayList<>(t));
            return;
        }

        t.add(nums[cur]);
        dfs(nums, cur + 1);
        t.remove(t.size() - 1);
        dfs(nums, cur + 1);
    }

}
