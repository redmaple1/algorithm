package com.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode22 {

    private List<String> res = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        if(n == 0) {
            return res;
        }

        backTrack("", n, 0);
        return res;
    }

    // 路径：p[0,index] 有效的括号组合
    // 可选路径：index 可选的座位括号组合的一部分
    // 终止条件：p的长度 == 2n
    private void backTrack(String p, int n, int index) {
        if(p.length() == 2 * n) {
            res.add(new String(p));
            return;
        }

        // 可选 ( 或 )
        char[] arr = new char[]{'(',')'};
        for(int i = 0; i < 2; i++) {
            // 过滤不符合条件的
            if(!isValid(p, arr[i], n)) {
                continue;
            }

            // 选择
            sb.append(arr[i]);
            p = sb.toString();
            backTrack(p, n, index + 1);
            // 撤销选择
            p = p.substring(0, p.length() - 1);
            sb.deleteCharAt(p.length());
        }
    }

    private boolean isValid(String p, char c, int max) {
        int n = p.length();
        int openCount = 0, closeCount = 0;
        char[] arr = p.toCharArray();
        for(int i = 0; i < n; i++) {
            if(arr[i] == '(') {
                openCount++;
            }
            if(arr[i] == ')') {
                closeCount++;
            }
        }
        if(openCount < max) {
            if (c == '(') {
                return true;
            }
        }
        if (openCount > max || (openCount == max && c == '(')) {
            return false;
        }
        if (closeCount < openCount) {
            if (c == ')') {
                return true;
            }
        }
        if (closeCount > max || (closeCount == max && c == ')')) {
            return false;
        }
        if (openCount == closeCount) {
            if (c == ')') {
                return false;
            }
        }
        return true;
    }

}
