import java.io.*;
import java.util.*;

public class Matrix_1080 {
    static int N, M;
    static int[][] prevMatrix, postMatrix;
    /*
        [way 1] 백트래킹 - 시간복잡도: O(2^(N*M)) -> 시간 초과
        [way 2] 그리디 - 시간 복잡도: O(N × M)
                => 전 행렬과 후 행렬에서 시작점이 다를 때 뒤집는 것만으로도 flip 최소 횟수가 보장
    */

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        prevMatrix = new int[N][M];
        for (int r = 0; r < N; r ++) {
            String line = br.readLine();
            for (int c = 0; c < M; c ++) {
                prevMatrix[r][c] = line.charAt(c) - '0';
            }
        }

        postMatrix = new int[N][M];
        for (int r = 0; r < N; r ++) {
            String line = br.readLine();
            for (int c = 0; c < M; c ++) {
                postMatrix[r][c] = line.charAt(c) - '0';
            }
        }

        if (N < 3 || M < 3) {
            if (isSame())
                System.out.println(0);
            else
                System.out.println(-1);
            return;
        }

        int answer = 0;

        for (int r = 0; r <= N - 3; r++) {
            for (int c = 0; c <= M - 3; c++) {
                if (prevMatrix[r][c] != postMatrix[r][c]) {
                    flip(r, c);
                    answer++;
                }
            }
        }

        if (isSame()) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }


    }

    // 3x3 flip 함수
    static void flip(int row, int col) {
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                prevMatrix[r][c] = 1 - prevMatrix[r][c];
            }
        }
    }

    // 같은지 확인
    static boolean isSame() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (prevMatrix[r][c] != postMatrix[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}