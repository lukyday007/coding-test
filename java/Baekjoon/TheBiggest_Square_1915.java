package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheBiggest_Square_1915 {
    /*
        [way1] 완전탐색 -> (당연하지만) 시간초과 O(N^2 * M^2)
        [way2] dp -> O(N * M) => Pass!
     */

    static class Solution_DP {
        static int N, M;
        static int[][] board;
        static int[][] dp;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            board = new int[N][M];
            dp = new int[N][M];

            for (int r = 0; r < N; r++) {
                String tmp = br.readLine();
                for (int c = 0; c < M; c++) {
                    board[r][c] = tmp.charAt(c) - '0';
                }
            }

            int maxLen = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (board[r][c] == 1) {
                        if (r == 0 || c == 0) {
                            dp[r][c] = 1;
                        } else {
                            dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + 1;
                        }
                        maxLen = Math.max(maxLen, dp[r][c]);
                    }
//                    System.out.println("r : " + r + ", c : " + c);
//                    for (int i = 0; i < N; i ++) {
//                        System.out.println(Arrays.toString(dp[i]));
//                    }
//                    System.out.println();
                }
            }
            System.out.println(maxLen * maxLen);
        }
    }


    class Solution_BruteForce {
        static int N, M;
        static int[][] board;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            board = new int[N][M];

            for (int r = 0; r < N; r++) {
                String tmp = br.readLine();
                for (int c = 0; c < N; c++) {
                    board[r][c] = Integer.parseInt(String.valueOf(tmp.charAt(c)));
                }
            }

            int maxVal = Integer.MIN_VALUE;
            // 최대 -> 최소
            for (int n = Math.min(N, M); n > 0; n--) {
                for (int r = 0; r <= N - n; r++) {
                    for (int c = 0; c <= M - n; c++) {
                        if (isSquare(r, c, n))
                            maxVal = Math.max(maxVal, n * n);
                    }
                }
            }
            System.out.println(maxVal);
        }

        private static boolean isSquare(int r, int c, int n) {
            for (int nr = r; nr < r + n; nr++) {
                for (int nc = c; nc < c + n; nc++) {
                    if (board[nr][nc] == 0) return false;
                }
            }
            return true;
        }
    }
}