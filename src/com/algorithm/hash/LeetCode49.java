package com.algorithm.hash;

import java.util.*;

public class LeetCode49 {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = groupAnagrams1(strs);
        System.out.printf(res.toString());
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String curStr = strs[i];
            char[] chars = curStr.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            List<String> list = map.getOrDefault(sortedStr, new ArrayList<>());
            list.add(curStr);
            map.put(sortedStr, list);
        }

        List<List<String>> res = new ArrayList<>();
        map.forEach((k, v) -> {
            res.add(v);
        });

        return res;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> indexMap = new HashMap<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String curStr = strs[i];
            List<Integer> charList = new ArrayList<>();
            for(int j = 0; j < curStr.length(); j++){
                char wordCur = curStr.charAt(j);
                charList.add((int) wordCur);
            }
            // 单词内字母排序
            Collections.sort(charList);
            // 拼接成字符串，作为key
            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < charList.size(); k++){
                sb.append(charList.get(k));
            }
            String key = sb.toString();
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
                indexMap.get(key).add(curStr);
            }else {
                map.put(key, 1);
                ArrayList list = new ArrayList();
                list.add(curStr);
                indexMap.put(key, list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        // 结果在indexMap中
        indexMap.forEach((k ,v) -> {
            res.add(v);
        });

        return res;

    }
}
