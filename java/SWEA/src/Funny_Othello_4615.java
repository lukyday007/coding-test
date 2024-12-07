import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Funny_Othello_4615 {
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] board = new int[N][N];

            board[N/2 - 1][N/2 - 1] = 2;
            board[N/2][N/2] = 2;
            board[N/2][N/2 - 1] = 1;
            board[N/2 - 1][N/2] = 1;

            for (int m = 0; m < M; m ++) {
                st = new StringTokenizer(br.readLine());
                int cr = Integer.parseInt(st.nextToken()) - 1;
                int cc = Integer.parseInt(st.nextToken()) - 1;
                int color = Integer.parseInt(st.nextToken());

                board[cr][cc] = color;

                for (int d = 0; d < 8; d ++) {
                    int nr = cr + dr[d];
                    int nc = cc + dc[d];
                    boolean flag = false;

                    while (0 <= nr && nr < N && 0 <= nc && nc < N && board[nr][nc] != 0) {
                        // 같은 색 돌이 있을 때
                        if (board[nr][nc] == color) {
                            flag = true;
                            break;
                        }
                        // 다른 색 돌이 있을 때 -> 같은 방향 + 1 이동
                        nr = nr + dr[d];
                        nc = nc + dc[d];
                    }

                    if (flag) {
                        while (flag) {
                            board[nr][nc] = color;
                            nr -= dr[d];
                            nc -= dc[d];

                            if (nr == cr && nc == cc) break;
                        }
                    }
                    flag = false;
                }
            }
            int black = 0;
            int white = 0;

            for (int r = 0; r < N; r ++) {
                for (int c = 0; c < N; c ++) {
                    if (board[r][c] == 1) black ++;
                    if (board[r][c] == 2) white ++;
                }
            }

            System.out.println("#" + (t+1) + " " + black + " " + white);
        }
    }
}


