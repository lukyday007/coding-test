package Programmers;
import java.util.*;

public class Lv3_School_To_Path {

    class Solution_dp {
        public int solution(int m, int n, int[][] puddles) {
            int[][] dp = new int[n + 1][m + 1];

            // 웅덩이 표시
            for (int[] puddle : puddles) {
                int x = puddle[0];
                int y = puddle[1];
                dp[y][x] = -1;
            }

            dp[1][1] = 1;

            for (int r = 1; r <= n; r++) {
                for (int c = 1; c <= m; c++) {
                    if (r == 1 && c == 1) continue;
                    if (dp[r][c] == -1) {
                        dp[r][c] = 0; // 웅덩이
                        continue;
                    }

                    if (dp[r - 1][c] != -1) dp[r][c] += dp[r - 1][c];
                    if (dp[r][c - 1] != -1) dp[r][c] += dp[r][c - 1];

                    dp[r][c] %= 1000000007;
                }
            }

            return dp[n][m];
        }
    }
}