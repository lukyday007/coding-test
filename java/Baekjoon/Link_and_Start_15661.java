import java.util.*;
import java.io.*;

public class Link_and_Start_15661 {
    static int N;
    static int[] rowSum, colSum;
    static int minVal = Integer.MAX_VALUE;

    /*
        sumTotal - rowSum[index] - colSum[index]
        ✔️ 특정 선수를 스타트 팀에 포함하면, 해당 선수와 연관된 모든 능력치(rowSum, colSum)를 한 번에 제거
        ✔️ 이 방식은 능력치가 대칭(대각선 값이 0)이라는 특성을 이용하여 중복 계산을 줄이는 역할
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        rowSum = new int[N];
        colSum = new int[N];

        int sum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                sum += num;
                rowSum[i] += num;
                colSum[j] += num;
            }
        }
        backtracking(0, 0, sum);
        System.out.println(minVal);
        br.close();
    }

    private static void backtracking(int index, int cnt, int sumTotal) {
        if (index == N || cnt == N/2) {
            minVal = Math.min(minVal, Math.abs(sumTotal));
            return;
        }
        backtracking(index + 1, cnt + 1, sumTotal - rowSum[index] - colSum[index]);
        backtracking(index + 1, cnt, sumTotal);
    }
}