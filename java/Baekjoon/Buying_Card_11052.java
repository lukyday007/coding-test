import java.util.*;
import java.io.*;

public class Buying_Card_11052 {
    static int[] dp, prices;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        prices = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i ++) {
            int tmp = Integer.parseInt(st.nextToken());
            prices[i] = tmp;
            dp[i] = tmp;
        }

        dp[0] = 0;
        // 사는 카드 개수 중심으로 접근 : 한 개, 두 개, 세 개일 때...
        for (int i = 1; i <= N; i ++) {
            for (int j = 1; j <= i; j ++) {
//                System.out.println("i : " + i + ",  i - j: " + (i-j) + ",  j: " + j + ",  dp[" + i + "]: " + dp[i] + ",  dp[" + i + " - " + j + "] + prices["+ j + "]: " + (dp[i-j] + prices[j]));
                dp[i] = Math.max(dp[i], dp[i - j] + prices[j]);
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i ++)
            answer = Math.max(dp[i], answer);

        System.out.println(answer);
    }
}
