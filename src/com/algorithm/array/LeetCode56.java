package com.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode56 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,4},{2,3}};
        int[][] res = merge(intervals);
        System.out.println(res);
    }

    public static int[][] merge(int[][] intervals) {
        // 按左边界从小到大排序
        int n = intervals.length;

        if(n == 1){
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int[] cur = new int[2];
        cur[0] = intervals[0][0];
        cur[1] = intervals[0][1];

        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < n - 1; i++){
            if(intervals[i + 1][0] <= cur[1]){
                // i+1 的左边界 <= 当前合并后的右边界，可以合并
                cur[1] = Math.max(intervals[i + 1][1], cur[1]);

            } else {
                // 需要新开区间
                list.add(new int[]{cur[0],cur[1]});

                cur[0] = intervals[i + 1][0];
                cur[1] = intervals[i + 1][1];


            }
            if (i == n - 2){
                list.add(new int[]{cur[0],cur[1]});
            }
        }

        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            int[] arr = list.get(i);
            res[i][0] = arr[0];
            res[i][1] = arr[1];
        }

        return res;
    }
}
