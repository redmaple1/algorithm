package com.algorithm.substring;

import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = minWindow(s, t);
        System.out.println(res);
    }

    public static String minWindow(String s, String t) {

        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        // 当前窗口中符合need要求的字符数，当 count == need.size() 时，可以shrink窗口
        int count = 0;
        int len = Integer.MAX_VALUE;
        // 符合要求的字符串起始索引
        int start = 0;

        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)){
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(windowMap.get(c))){
                    count++;
                }
            }

            while (count == need.size()){

                if (right - left < len){
                    len = right - left;
                    start = left;
                }

                // 窗口左边界右移
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (need.get(d).equals(windowMap.get(d))){
                        count--;
                    }
                    windowMap.put(d, windowMap.get(d) - 1);
                }

            }


        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
