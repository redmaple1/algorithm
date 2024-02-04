package com.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {

    private List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        LeetCode17 handle = new LeetCode17();
        List<String> res = handle.letterCombinations("23");
        System.out.println(res);
    }

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return res;
        }
        backTrack("",0, digits);
        return res;
    }

    // 路径：p[0,index] 组合的结果
    // 选择路径：第index位可选择的字母
    // 结束条件：p的长度==digits的长度
    private void backTrack(String p, int index, String digits) {
        int n = digits.length();
        if(n == p.length()) {
            res.add(p);
            return;
        }

        // 第index位的数字可代表的字母
        char[] arr = target(Integer.parseInt(String.valueOf(digits.charAt(index))));

        for(int i = 0; i < arr.length; i++) {
            // 选择

            sb.append(arr[i]);
            p = sb.toString();
            backTrack(p, index + 1, digits);
            // 撤销选择
            p = p.substring(0, p.length() - 1);
            sb.deleteCharAt(p.length());
        }
    }

    private char[] target(int i) {
        switch(i) {
            case 2:
                return new char[]{'a','b','c'};
            case 3:
                return new char[]{'d','e','f'};
            case 4:
                return new char[]{'g', 'h', 'i'};
            case 5:
                return new char[]{'j','k','l'};
            case 6:
                return new char[]{'m','n','o'};
            case 7:
                return new char[]{'p','q','r','s'};
            case 8:
                return new char[]{'t','u','v'};
            case 9:
                return new char[]{'w','x','y','z'};
        }
        throw new IllegalArgumentException("不符合入参条件");
    }
}
