package PACKAGE_NAME;
import java.util.*;

public class Lv3_Undamaged_Buildings {
    static int ROW, COL, SKI;

    public int solution(int[][] board, int[][] skill) {
        ROW = board.length;
        COL = board[0].length;
        SKI = skill.length;

        int[][] prefix = new int[ROW + 1][COL + 1];

        // 누적합 배열(prefix) 업데이트
        for (int s = 0; s < SKI; s++) {
            int type = skill[s][0];
            int r1 = skill[s][1];
            int c1 = skill[s][2];
            int r2 = skill[s][3];
            int c2 = skill[s][4];
            int degree = skill[s][5];

            // 공격이면 음수, 회복이면 양수
            int effect = (type == 1) ? -degree : degree;

            prefix[r1][c1] += effect;
            prefix[r1][c2 + 1] -= effect;
            prefix[r2 + 1][c1] -= effect;
            prefix[r2 + 1][c2 + 1] += effect;
        }

        // 행 업데이트
        for (int r = 0; r < ROW; r ++) {
            for (int c = 1; c < COL; c ++) {
                prefix[r][c] += prefix[r][c-1];
            }
        }

        // 열 업데이트
        for (int c = 0; c < COL; c ++) {
            for (int r = 1; r < ROW; r ++) {
                prefix[r][c] += prefix[r-1][c];
            }
        }

        int answer = 0;
        for (int r = 0; r < ROW; r ++) {
            for (int c = 0; c < COL; c ++) {
                board[r][c] += prefix[r][c];
                if (board[r][c] > 0)
                    answer ++;
            }
        }

        return answer;
    }
}