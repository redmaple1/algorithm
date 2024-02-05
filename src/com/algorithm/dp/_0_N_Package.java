package com.algorithm.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 0-N背包
 */
public class _0_N_Package {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 背包容量C
        int C = scanner.nextInt();
        // 物品总数
        int N = scanner.nextInt();

        int[] c = new int[N + 1];
        int[] w = new int[N + 1];
        int[] q = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            c[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
            q[i] = scanner.nextInt();
        }

        int[] dp = new int[C + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = dp.length - 1; j > 0; j--) {
                for (int k = 0; k <= q[i] && (j - k * c[i] >= 0); k++) {
                    dp[j] = Math.max(dp[j],dp[j - k * c[i]] + k * w[i]);
                }
            }
        }
        System.out.println(dp[C]);

//        rollingArray(C, N, c, w, q);

//        twoDimension(C, N, c, w, q);
    }

    // 滚动数组优化
    private static void rollingArray(int C, int N, int[] c, int[] w, int[] q) {
        int[][] dp = new int[2][C + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                for (int k = 0; k <= q[i] && (j - k * c[i] >= 0); k++){
                    dp[i % 2][j] = Math.max(dp[i % 2][j], dp[(i - 1) % 2][j - k * c[i]] + k * w[i]);
                }
            }
        }
        int res = N % 2 == 0 ? dp[0][C] : dp[1][C];
        System.out.println(res);
    }

    // 非优化实现
    private static void twoDimension(int C, int N, int[] c, int[] w, int[] q) {
        int[][] dp = new int[N + 1][C + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                for (int k = 0; k <= q[i] && (j - k * c[i] >= 0); k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * c[i]] + k * w[i]);
                }
            }
        }

        System.out.println(dp[N][C]);
    }

}
