package com.algorithm.backtrack;

import java.util.*;

public class LeetCode39 {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> p = new ArrayList<>();
    int trackSum = 0;
    private Set arrSet = new HashSet<>();

    public static void main(String[] args) {
        int[] candicates = new int[]{2,3,6,7};
        int target = 7;
        LeetCode39 handle = new LeetCode39();
        List<List<Integer>> res = handle.combinationSum(candicates, target);
        System.out.println(res);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        backTrack(candidates, target, 0);
        return res;
    }

    private void backTrack(int[] candidates, int target, int start) {
        if(trackSum == target) {
            Integer[] intArr = new Integer[p.size()];
            p.toArray(intArr);
            Arrays.sort(intArr);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < intArr.length; i++) {
                sb.append(intArr[i]);
            }
            String s = sb.toString();

            if(arrSet.contains(s)) {
                return;
            }
            arrSet.add(s);
            res.add(new ArrayList<>(p));
            return;
        }

        if(trackSum > target) {
            return;
        }

        int n = candidates.length;
        for(int i = start; i < n; i++) {
            // 选择
            trackSum += candidates[i];
            p.add(candidates[i]);

            backTrack(candidates, target, start);
            // 撤销选择
            p.remove(p.size() - 1);
            trackSum -= candidates[i];
        }
    }
}
