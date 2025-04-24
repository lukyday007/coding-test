import java.util.*;
import java.io.*;
public class Finding_Square_Number_1025 {
    static int R, C;
    static int[][] board;
    static long answer = -1;
    /*
        행의 번호가 선택한 순서대로 등차수열을 이루고 있어야 하고,
        열의 번호도 선택한 순서대로 등차수열
    */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];

        for (int r = 0; r < R; r ++) {
            String tmp = br.readLine();
            for (int c = 0; c < C; c ++)
                board[r][c] = tmp.charAt(c) - '0';
        }

        for (int r = 0; r < R; r ++) {
            for (int c = 0; c < C; c ++) {
                for (int diffR = -R; diffR < R; diffR ++) {
                    for (int diffC = -C; diffC < C; diffC ++) {
                        if (diffR == 0 && diffC == 0)   continue;

                        int num = 0;
                        int nr = r + diffR;
                        int nc = c + diffC;

                        while (nr > 0 && nr < R && nc > 0 && nc < C) {
                            num = num * 10 + board[nr][nc];
                            if (isSquare(num)) {
                                answer = Math.max(answer, num);
                            }
                            // 공차 계속 더하기 - 행, 열
                            nr += diffR; nc += diffC;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean isSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}