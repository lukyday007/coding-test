import java.util.*;
import java.io.*;

public class Longest_Increasing_Subsequence4_14002 {
    static int N;
    static int answer;
    static int[] dp;
    static int[] check;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        arr = new int[N + 1];
        check = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i ++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i ++) {
            int max = 0;
            for (int j = 0; j < i; j ++) {
                if (arr[j] < arr[i]) {  // 증가 부분수열일 경우
                    if (max < dp[j])
                        check[j] = i;

                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }

        for (int i = 0; i <= N; i ++) {
            if (answer < dp[i]) {
                answer = dp[i];
            }
        }

        System.out.println(answer);
        for (int i = 1; i <= answer; i ++) {
            int max = 0;
            for (int j = 0; j <= N; j ++) {
                if (dp[j] == i && max < j)
                    max = j;
            }
        }

        // [문제 & 해결] 뒤에서 부터 정답에 해당하는 행렬 저장하기
        List<Integer> result = new ArrayList<>();
        int num = answer;
        int idx = N;
        while (num > 0) {
            if (num == dp[idx]) {
                result.add(arr[idx]);
                num --;
            }

            idx --;
        }

        for (int i = answer - 1; i >= 0; i --) {
            System.out.print(result.get(i) + " ");
        }
    }
}
