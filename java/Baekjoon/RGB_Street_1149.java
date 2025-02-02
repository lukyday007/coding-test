import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RGB_Street_1149 {
    static int N;
    static int answer;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[][] dp;

    /*
        각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
        -   1번 집의 색은 2번 집의 색과 같지 않아야 한다.
        -   N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
        -   i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

        집을 칠하는 비용은 1,000보다 작거나 같은 자연수

        R  G  B
        26 40 83
        49 60 57
        13 89 99
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < N; i++)
            arr.add(new ArrayList<>());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr.get(i).add(Integer.parseInt(st.nextToken())); // 빨강
            arr.get(i).add(Integer.parseInt(st.nextToken())); // 초록
            arr.get(i).add(Integer.parseInt(st.nextToken())); // 파랑
        }

        dp = new int[N][3];

        for (int i = 0; i < 3; i++)
            dp[0][i] = arr.get(0).get(i);

        for (int i = 1; i < N; i++) {
            dp[i][0] = arr.get(i).get(0) + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr.get(i).get(1) + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr.get(i).get(2) + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        // 정답 출력
        System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
    }
}
