package com.algorithm.slidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LeetCode438 {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> res = findAnagrams(s, p);
        System.out.println(res);
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0 || p == null || p.length() == 0){
            return res;
        }

        int n = s.length(), m = p.length();

        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for (int i = 0; i < m; i++) {
            pCnt[p.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCnt,sCnt)){
            res.add(0);
        }

        for (int i = m; i < n; i++) {
            sCnt[s.charAt(i) - 'a']++;
            sCnt[s.charAt(i - m) - 'a']--;

            if (Arrays.equals(sCnt,pCnt)){
                res.add(i - m + 1);
            }
        }
        return res;
    }
}
