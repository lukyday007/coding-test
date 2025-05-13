import java.util.*;
import java.io.*;

public class Retirement_2_15486 {
    static int N;
    static int[] days, pays, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        days = new int[N];
        pays = new int[N];
        dp = new int[N + 1];

        StringTokenizer st;
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            pays[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i ++) {
            /*
                dp[i] + pays[i] : 오늘 상담을 선택했을 때 미래에 받을 수 있는 총 수익
                dp[i + days[i]] : 이미 알고 있는, 해당 날짜까지 가능한 최대 수익
            */
            if (i + days[i] <= N)
                dp[i + days[i]] = Math.max(dp[i] + pays[i], dp[i + days[i]]);

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[N]);
    }
}