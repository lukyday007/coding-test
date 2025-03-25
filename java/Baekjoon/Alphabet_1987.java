import java.util.*;
import java.io.*;

public class Alphabet_1987 {
    static int R, C;
    static int MaxVal = Integer.MIN_VALUE;
    static char[][] board;
    static boolean[][] check;
    static int[] dr = {1, -1, 0, 0} , dc = {0, 0, -1, 1};

    public static void dfs(int r, int c, Set<Character> alphabets) {

        if (alphabets.size() > MaxVal) {
            MaxVal = Math.max(alphabets.size(), MaxVal);
        }
        for (int d = 0; d < 4; d ++) {
            int nr = r + dr[d], nc = c + dc[d];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C || check[nr][nc] || alphabets.contains(board[nr][nc])) continue;

            check[nr][nc] = true;
            alphabets.add(board[nr][nc]);
            dfs(nr, nc, alphabets);
            alphabets.remove(board[nr][nc]);
            check[nr][nc] = false;
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

        check = new boolean[R][C];
        Set<Character> alphabets = new HashSet<>();
        alphabets.add(board[0][0]);
        check[0][0] = true;
        dfs(0, 0, alphabets);

        System.out.println(MaxVal);
    }
}