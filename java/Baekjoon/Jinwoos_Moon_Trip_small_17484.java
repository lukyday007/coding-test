package Baekjoon;

import java.util.*;
import java.io.*;
public class Jinwoos_Moon_Trip_small_17484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] board = new int[R][C];
        int[][][] dp = new int[R][C][3];
        int[] dc = new int[]{-1, 0, 1};

        for (int r = 0; r < R; r++)
            for (int c = 0; c < C; c++)
                Arrays.fill(dp[r][c], Integer.MAX_VALUE);

        for (int r = 0; r < R; r ++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c ++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값 및 방향 셋팅
        for (int c = 0; c < C; c++) {
            for (int d = 0; d < 3; d++) {
                dp[0][c][d] = board[0][c];
            }
        }

        for (int r = 0; r < R; r ++) {
            for (int c = 0; c < C; c ++) {
                for (int pd = 0; pd < 3; pd ++) {
                    int cur = dp[r][c][pd];
                    if (cur == Integer.MAX_VALUE)   continue;

                    for (int d = 0; d < 3; d ++) {
                        if (d == pd)    continue;
                        int nr = r + 1, nc = c + dc[d];
                        if (nr >= R || nc < 0 || nc >= C)  continue;
                        dp[nr][nc][d] = Math.min(dp[nr][nc][d], board[nr][nc] + cur);
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int c = 0; c < C; c++)
            for (int dir = 0; dir < 3; dir++)
                ans = Math.min(ans, dp[R-1][c][dir]);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}