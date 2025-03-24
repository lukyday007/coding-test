import java.util.*;
import java.io.*;

public class Candy_Store_4781 {
    static int [] dp;
    static int c, m;
    static float LIMIT_PRICE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        c = -1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            LIMIT_PRICE = Float.parseFloat(st.nextToken());

            if (c == 0 && LIMIT_PRICE == 0.00)
                break;

            m = (int) (LIMIT_PRICE * 100 + 0.5);    // float -> int 과정에서 반올림 오차를 줄이기 위한 + 0.5
            dp = new int[m + 1];
            for (int i = 0; i < c; i ++) {
                st = new StringTokenizer(br.readLine());
                int calorie = Integer.parseInt(st.nextToken());
                int money = (int) (Float.parseFloat(st.nextToken()) * 100 + 0.5);

                for (int j = 0; j <= m; j ++)
                    if (j - money >= 0)
                        dp[j] = Math.max(dp[j], dp[j-money] + calorie);

            }

            sb.append(dp[m]).append("\n");
        }
        System.out.println(sb);
    }
}