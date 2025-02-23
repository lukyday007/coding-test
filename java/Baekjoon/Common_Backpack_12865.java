import java.util.*;
import java.io.*;

public class Common_Backpack_12865 {
    static int N, K;    // 물품 수, 버틸 수 있는 무게
    static int[] weights, values;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        weights = new int[N];
        values = new int[N];
        dp = new int[K + 1][N + 1];     // 행 : 가치, 열 : 무게

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            weights[i] = w;
            values[i] = v;
        }

        for (int w = 1; w <= K; w ++) {
            for (int v = 1; v <= N; v ++) {

                if (w >= weights[v-1])
                    dp[w][v] = Math.max(dp[w - weights[v - 1]][v - 1] + values[v - 1], dp[w][v - 1]);
                else
                    dp[w][v] = dp[w][v - 1];

            }
        }
        int answer = 0;
        for (int i = 0; i < dp.length; i ++)
            answer = Math.max(dp[i][N], answer);

        System.out.println(answer);
    }
}
