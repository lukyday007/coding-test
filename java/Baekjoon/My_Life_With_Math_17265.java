package Baekjoon;

import java.util.*;
import java.io.*;
public class My_Life_With_Math_17265 {
    static int N;
    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;
    static char[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;
        for (int r = 0; r < N; r ++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c ++) {
                board[r][c] = st.nextToken().charAt(0);
            }
        }

        visited[0][0] = true;
        dfs(0, 0, 0, String.valueOf(board[0][0]));

        StringBuilder sb = new StringBuilder();
        sb.append(maxVal).append(" ").append(minVal);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int r, int c, String val) {
        if (r == N - 1 && c == N - 1) {
            int result = calculate(val);
            minVal = Math.min(result, minVal);
            maxVal = Math.max(result, maxVal);
            return;
        }

        if (r + 1 < N) {
            visited[r + 1][c] = true;
            dfs(depth + 1, r + 1, c, val + board[r + 1][c]);
            visited[r + 1][c] = false;
        }

        if (c + 1 < N) {
            visited[r][c + 1] = true;
            dfs(depth + 1, r, c + 1, val + board[r][c + 1]);
            visited[r][c + 1] = false;
        }
    }

    private static int calculate(String val) {
        int result = Integer.valueOf(val.charAt(0)) - '0';

        for (int i = 1; i < (val.length() + 1)/2; i++) {
            char op = val.charAt(2 * i - 1);
            int num = Integer.valueOf(val.charAt(2 * i)) - '0';

            if (op == '+') {
                result += num;
            } else if (op == '-') {
                result -= num;
            } else {
                result *= num;
            }
        }
        return result;
    }
}