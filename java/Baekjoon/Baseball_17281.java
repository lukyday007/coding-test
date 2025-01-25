import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baseball_17281 {
    /*
        1. 타순 짜기
        2. 매 이닝 반복할 것
        3. 타자의 행동
        4. 아웃 카운트가 3개가 되면 다음 이닝으로

        java baekjoon: 17281_⚾ - 17348kb, 512ms
    */
    static int inning, maxV;
    static int[][] input;
    static boolean[] visit, base;
    static int[] players;
    static StringTokenizer st;

    private static void permutation(int num) {
        if (num == 9) {
            int score = playGame();
            maxV = Math.max(maxV, score);
            return;
        }
        for (int i = 0; i < 9; i ++) {
            if (visit[i])
                continue;
            visit[i] = true;
            players[i] = num;
            permutation(num + 1);
            visit[i] = false;
        }
    }
    private static int playGame() {
        // 순서가 정렬된 players 배열로 점수 계산 시작
        int score = 0;
        int idx = 0;
        for (int i = 0; i < inning; i ++) {
            base[0] = false;
            base[1] = false;
            base[2] = false;

            int out = 0;
            while (out < 3) {
                int hit = input[i][players[idx]];
                if (hit == 0)
                    out ++;
                else if (hit == 4) {    // 홈런
                    for (int j = 0; j < 3; j ++) {
                        if (base[j]) {
                            score++;
                            base[j] = false;
                        }
                    }
                    score ++;
                } else {
                    score += move(hit, base);
                }

                idx ++;
                if (idx == 9)
                    idx = 0;
            }
        }
        return score;
    }
    private static int move(int hit, boolean[] base) {
        int score = 0;
        // 앞서 베이스에 있는 사람들 먼저 이동
        for (int i = 2; i >= 0; i --) {
            if (base[i]) {
                if (hit + i >= 3) {
                    score++;
                } else {
                    base[hit + i] = true;
                }
                base[i] = false;
            }
        }
        // 타자 이동
        base[hit - 1] = true;

        return score;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inning = Integer.parseInt(br.readLine());
        input = new int[inning][9];
        for (int i = 0; i < inning; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j ++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxV = 0;
        visit = new boolean[9];
        players = new int[9];
        base = new boolean[3];
        visit[3] = true;        // 1번 주자 먼저 셋팅 - visit 체크
        players[3] = 0;         // 1번 주자 먼저 셋팅 - players 배열

        permutation(1);

        System.out.println(maxV);
    }
}