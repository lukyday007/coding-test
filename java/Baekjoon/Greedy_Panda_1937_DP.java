import java.util.*;
import java.io.*;

public class Greedy_Panda_1937_DP {
    static int N, ans;
    static int[][] board, dp;   // 메모이제이션
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    /*
        대나무를 먹고 자리를 옮기면 그 옮긴 지역에 그 전 지역보다 대나무가 많이 있어야 한다
        대나무 숲의 크기 n(1 ≤ n ≤ 500)
        최대한 많은 칸을 이동하려면 어떤 경로를 통하여 움직여야 하는지
    */
    public static int dfs(int r, int c) {
        if (dp[r][c] != -1) return dp[r][c];

        dp[r][c] = 1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d], nc = c + dc[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] <= board[r][c]) continue;

            dp[r][c] = Math.max(dp[r][c], 1 + dfs(nr, nc));
        }
        return dp[r][c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        dp = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        int maxMove = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxMove = Math.max(maxMove, dfs(i, j)); // 모든 위치에서 DFS 수행
            }
        }

        System.out.println(maxMove);
    }
}
