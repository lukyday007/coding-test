import java.util.*;
import java.io.*;

public class Testing_Wine_2156 {
    static int N;
    static int[] wines;
    static int[] dp;

    /*
        [error1] ArrayIndexOutOfBounds :
            dp[1] = wines[1]; // OK
            dp[2] = dp[1] + wines[2];  N == 1일 때, wines[2] 접근 → IndexOutOfBoundsException 발생

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        wines = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i ++)
            wines[i] = Integer.parseInt(br.readLine());

        dp[1] = wines[1];
        if (N >= 2) dp[2] = dp[1] + wines[2];
        if (N >= 3) dp[3] = Math.max(dp[1] + wines[3], dp[2]);

        for (int i = 3; i <= N; i ++) {
            dp[i] = Math.max(dp[i-1], Math.max(wines[i] + wines[i-1] + dp[i-3], wines[i] + dp[i-2]));
//            System.out.println(dp[i-1]);
        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
    }
}
