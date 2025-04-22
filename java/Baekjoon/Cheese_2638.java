import java.util.*;
import java.io.*;

public class Cheese_2638 {
    static int R, C;
    static int[][] board;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    // 치즈가 녹을 때 외부 공기와 내부 공기를 구분하는 방식을 처음부터 끝까지 적용

    /*
        Java에서는 특히 new 클래스()를 반복적으로 생성하면 GC(가비지 컬렉션) 비용도 올라가고, 힙 메모리를 금방 씀. 반면에 int[]나 단순 int는 스택에서 빠르게 처리되고 메모리 할당도 훨씬 가벼움

        ✅ 알고리즘 성능 최적화 팁
        단순 좌표는 int[]로
        → Point, Node 클래스 대신 int[]{r, c}를 쓰면 메모리·속도 모두 유리

        클래스 내부에서 반복적으로 객체를 생성하지 말 것
        → 특히 BFS, DFS 등에서 수천, 수만 번 반복될 경우 치명적임
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            markOutsideAir();

            List<int[]> meltList = new ArrayList<>();

            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (board[r][c] == 1) {
                        int airCount = 0;
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d], nc = c + dc[d];
                            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                                if (board[nr][nc] == 2) airCount++;
                            }
                        }
                        if (airCount >= 2) {
                            meltList.add(new int[]{r, c});
                        }
                    }
                }
            }

            if (meltList.isEmpty()) break;

            for (int[] pos : meltList) {
                board[pos[0]][pos[1]] = 0;
            }

            time++;
        }

        System.out.println(time);
    }

    static void markOutsideAir() {
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            board[cur[0]][cur[1]] = 2;

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d], nc = cur[1] + dc[d];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C &&
                        !visited[nr][nc] && board[nr][nc] != 1) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        // 내부 공기 리셋: 외부공기 2 외의 0은 다시 0으로 유지
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == 2 && !visited[r][c]) {
                    board[r][c] = 0;
                }
            }
        }
    }
}
