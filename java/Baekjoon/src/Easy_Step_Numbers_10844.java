import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Easy_Step_Numbers_10844 {

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new long[N + 1][10];
        long mod = 1000000000L;

        for (int i = 1; i < 10; i ++) {
            dp[1][i] = 1L;
        }

        if (N > 1) {
            for (int i = 2; i <= N; i ++) {
                for (int j = 0; j < 10; j ++) {
                    if (j == 0) {
                        dp[i][j] = dp[i-1][j+1]%mod;
                    } else if (j == 9) {
                        dp[i][j] = dp[i-1][j-1]%mod;
                    } else {
                        dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%mod;
                    }
                }
            }
        }

        long ans = 0L;
        for (long num : dp[N]) {
            ans += num;
        }
        System.out.println(ans % mod);
    }
}