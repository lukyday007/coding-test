import java.util.*;
import java.io.*;

public class Robot_Control_2169 {
    static int N, M;
    static int[][] board;
    static int[][] dp;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        dp = new int[N][M];  // DP 배열 초기화

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MIN_VALUE;  // DP 초기값 설정
            }
        }

        dp[0][0] = board[0][0];
        // dp 첫 줄 채우기
        for (int i = 0; i < M - 1; i ++)
            dp[0][i + 1] = dp[0][i] + board[0][i + 1];

        for (int i = 1; i < N; i ++) {
            int[] tmp1 = new int[M];
            int[] tmp2 = new int[M];
            for (int j = 0; j < M; j ++) {
                tmp1[j] = dp[i - 1][j] + board[i][j];
                tmp2[j] = dp[i - 1][j] + board[i][j];
            }

            // right
            for (int j = 0; j < M - 1; j ++)
                tmp1[j + 1] = Math.max(tmp1[j + 1], tmp1[j] + board[i][j + 1]);

            // left
            for (int j = M - 1; j > 0; j --)
                tmp2[j - 1] = Math.max(tmp2[j - 1], tmp2[j] + board[i][j - 1]);

            for (int j = 0; j < M; j ++) {
                if (tmp1[j] >= tmp2[j])
                    dp[i][j] = tmp1[j];
                else
                    dp[i][j] = tmp2[j];
            }
        }
        System.out.println(dp[N-1][M-1]);
    }
}
