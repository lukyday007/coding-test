import java.util.*;
import java.io.*;

public class Tetromino_14500 {
    static int R, C;
    static int[][] board;
    static int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        visited = new boolean[R][C];


        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < R; r ++) {
            for (int c = 0; c < C; c ++) {
                visited[r][c] = true;
                backtracking(r, c, 1, board[r][c]);
                visited[r][c] = false;
            }
        }

        System.out.println(answer );
    }

    public static class Point {
        int r ,c;
        public Point(int r, int c) {
            this.r = r; this.c = c;
        }
    }

    public static void backtracking (int r, int c, int depth, int total) {
        if (depth == 4) {
            answer = Math.max(total, answer);
//            if (answer == 4) {
//                for (Point pt: arr)
//                    System.out.println("r : " + pt.r + ", c : " + pt.c);
//                System.out.println();
//            }
            return;
        }

        for (int d = 0; d < 4; d ++) {
            int nr = r + dr[d], nc = c + dc[d];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C)     continue;
            if (visited[nr][nc])    continue;

            if (depth == 2) {   // ㅗ -> 0,1 1,1 1,2 1,0
                visited[nr][nc] = true;
                backtracking(r, c, depth + 1, total + board[nr][nc]);
                visited[nr][nc] = false;
            }

            visited[nr][nc] = true;
            backtracking(nr, nc, depth + 1, total + board[nr][nc]);
            visited[nr][nc] = false;
        }
    }
}