package Baekjoon;

import java.util.*;
import java.io.*;

public class Matrix_Multiple_Sequence_11049 {

    /*

    4
    10 100
    100 5
    5 50
    50 1

    len = 2, i = 0, j = 1
    dp[0][1] = dp[0][0] + dp[1][1] + cost(0,1,2)    // A0 × A1

    len = 2, i = 1, j = 2
    dp[1][2] = dp[1][1] + dp[2][2] + cost(1,2,3)    // A1 × A2

    len = 2, i = 2, j = 3
    dp[2][3] = dp[2][2] + dp[3][3] + cost(2,3,4)    // A2 × A3

    len = 3, i = 0, j = 2
    dp[0][2] = min(
        dp[0][0] + dp[1][2] + cost(0,1,3),          // (A0)(A1×A2)
        dp[0][1] + dp[2][2] + cost(0,2,3)           // (A0×A1)(A2)
    )

    len = 3, i = 1, j = 3
    dp[1][3] = min(
        dp[1][1] + dp[2][3] + cost(1,2,4),          // (A1)(A2×A3)
        dp[1][2] + dp[3][3] + cost(1,3,4)           // (A1×A2)(A3)
    )

    len = 4, i = 0, j = 3
    dp[0][3] = min(
        dp[0][0] + dp[1][3] + cost(0,1,4),          // (A0)(A1×A2×A3)
        dp[0][1] + dp[2][3] + cost(0,2,4),          // (A0×A1)(A2×A3)
        dp[0][2] + dp[3][3] + cost(0,3,4)           // (A0×A1×A2)(A3)
    )

    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] matrix = new int[N + 1];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            matrix[i] = r;
            matrix[i + 1] = c;
        }

        for (int len = 2; len <= N; len++) {       // len: 곱할 행렬의 수
            for (int i = 0; i <= N - len; i++) {   // i: 시작 행렬
                int j = i + len - 1;               // j: 끝 행렬
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
//                    System.out.println("[" + i + ", " + k + "], " + " [" + (k+1) + ", " + j + "], " + " [" + i + "], " + " [" + (k+1) + "], " + " [" + (j + 1) + "], ");
                    int cost = dp[i][k] + dp[k + 1][j] + matrix[i] * matrix[k + 1] * matrix[j + 1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        System.out.println(dp[0][N-1]);
    }
}