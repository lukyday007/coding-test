import java.util.*;
import java.io.*;

public class Alphabet_1987 {
    static int R, C;
    static int MaxVal = Integer.MIN_VALUE;
    static char[][] board;
    static boolean[] check;
    static int[] dr = {1, -1, 0, 0} , dc = {0, 0, -1, 1};

    /*
        문자에서 정수 인덱스를 얻는 방법!
        => board[nr][nc] - 'A'
    */

    public static void dfs(int r, int c, int total, int idx) {

        if (total > MaxVal) {
            MaxVal = Math.max(total, MaxVal);
        }
        for (int d = 0; d < 4; d ++) {
            int nr = r + dr[d], nc = c + dc[d];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            idx = board[nr][nc] - 'A';
            if (check[idx]) continue;

            check[idx] = true;
            dfs(nr, nc, total + 1, idx);
            check[idx] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int r = 0; r < R; r ++) {
            String tmp = br.readLine();
            for (int c = 0; c < C; c ++) {
                board[r][c] = tmp.charAt(c);
            }
        }

//        for (int r = 0; r < R; r ++)
//            System.out.println(Arrays.toString(board[r]));

        check = new boolean[26];
        check[board[0][0] - 'A'] = true;

        dfs(0, 0, 1, 0);
        System.out.println(MaxVal);
    }
}