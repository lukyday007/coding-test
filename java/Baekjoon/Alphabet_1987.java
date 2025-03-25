import java.util.*;
import java.io.*;

public class Alphabet_1987 {
    static int R, C;
    static int MaxVal = Integer.MIN_VALUE;
    static char[][] board;
    static boolean[] check;
    static int[] dr = {1, -1, 0, 0} , dc = {0, 0, -1, 1};

    /*
        [optimization 1] 문자에서 정수 인덱스를 얻는 방법!
        => board[nr][nc] - 'A'

        [optimization 2] bitmasking
        - Java의 int는 32비트 정수
        - 알파벳 26개 = 26비트만 사용 → 충분히 int 안에 다 들어감.
        - int가 4바이트(= 32비트)니까, 1 << 25도 무리 없이 표현 가능.

        ✅ But!  32개 이상이면 long (64비트)을 쓰거나, 더 많아지면 BitSet, boolean[], Set<Character>로 전환!!!

    */

    public static void dfs(int r, int c, int total, int bitmask) {

        if (total > MaxVal) {
            MaxVal = Math.max(total, MaxVal);
//            System.out.println("bitmask ; " + Integer.toBinaryString(bitmask));
        }
        for (int d = 0; d < 4; d ++) {
            int nr = r + dr[d], nc = c + dc[d];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            int idx = board[nr][nc] - 'A';

            if ((bitmask & (1 << idx)) != 0) continue;

            dfs(nr, nc, total + 1, bitmask | (1 << idx));
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
        int staIdx = board[0][0] - 'A';
        check[staIdx] = true;

        dfs(0, 0, 1, (1 << staIdx));
        System.out.println(MaxVal);
    }
}