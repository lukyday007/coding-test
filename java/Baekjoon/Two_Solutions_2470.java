import java.util.*;
import java.io.*;

public class Two_Solutions_2470 {
    static int N;
    static long[] solutions;
    public static void main (String[] main) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        solutions = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++)
            solutions[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(solutions);

        // 특성값이 0에 가장 가까운 용액
        int l = 0, r = N - 1;
        long[] result = new long[2];
        long diff = Long.MAX_VALUE;
        while (l < r) {
            long tmp = solutions[l] + solutions[r];
            if (diff > Math.abs(tmp)) {
                diff = Math.abs(tmp);
                result[0] = solutions[l];
                result[1] = solutions[r];
            }

            if (tmp > 0)        // 합이 양수 → 산성 쪽으로 치우침 → 더 약한 산성으로 이동
                r--;
            else if (tmp < 0)   // 합이 음수 → 염기성 쪽으로 치우침 → 더 약한 염기성으로 이동
                l++;
            else                // 합이 0이면 완벽한 중성 → 종료
                break;
        }

        Arrays.sort(result);
        System.out.println(result[0] + " "+ result[1]);
    }
}
