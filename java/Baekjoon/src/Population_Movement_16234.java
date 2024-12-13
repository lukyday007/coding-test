import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Population_Movement_16234 {
    static int N, L, R;
    static int[][] board;
    static boolean[][] visit;
    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0, 0, -1, 1};

    public static boolean bfs(int sr, int sc) {
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[] {sr, sc});
        visit[sr][sc] = true;

        List<int[]> arr = new ArrayList<>();
        arr.add(new int[] {sr, sc});

        int sum = board[sr][sc];

        while(! Q.isEmpty()) {
            int[] current = Q.poll();
            int cr = current[0];
            int cc = current[1];

            for (int d = 0; d < 4; d ++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if (0 <= nr && nr < N && 0 <= nc && nc < N && !visit[nr][nc]) {
                    int val = Math.abs(board[cr][cc] - board[nr][nc]);
                    if (L <= val && val <= R) {
                        visit[nr][nc] = true;
                        Q.add(new int[] {nr, nc});
                        arr.add(new int[] {nr, nc});
                        sum += board[nr][nc];
                    }
                }
            }
        }
        if (arr.size() > 1) {
            int value = sum / arr.size();
            for (int[] tmp : arr) {
                board[tmp[0]][tmp[1]] = value;
            }
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (day <= 2000) {
            visit = new boolean[N][N];
            boolean flag1 = false;
            boolean flag2 = false;

            for (int r = 0; r < N; r ++) {
                for (int c = 0; c < N; c ++) {
                    if (!visit[r][c]) {
                        flag1 = bfs(r, c);
                        if (flag1)
                            flag2 = true;
                    }
                }
            }

            if (!flag2)
                break;

            day ++;
        }
        System.out.println(day);

    }
}
