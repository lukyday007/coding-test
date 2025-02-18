import java.util.*;
import java.io.*;

public class Longest_Increasing_Subsequence_11053 {
    static int N;
    static int answer;
    static int[] dp;
    static int[] arr;

    /*
        6
        10 20 10 30 20 50

        4
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i ++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i ++) {
            int max = 0;
            for (int j = 0; j < i; j ++) {
                if (arr[j] < arr[i])    // 증가 부분수열일 경우
                    max = Math.max(max, dp[j]);

            }
            dp[i] = max + 1;
        }

        for (int i = 0; i <= N; i ++) {
            if (answer < dp[i])
                answer = dp[i];
        }

        System.out.println(answer);
    }
}