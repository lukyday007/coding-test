import java.util.*;
import java.io.*;

public class Cutting_Trees_2805 {
    static int N;
    static long M;
    static long[] trees;
    static int answer = Integer.MIN_VALUE;
    /*
     * SUM < M : H를 줄인다
     * SUM >= M : H를 높인다
    */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        trees = new long[N];

        st = new StringTokenizer(br.readLine());
        long maxHeight = 0;
        long minHeight = Long.MAX_VALUE;
        for (int i = 0; i < N; i ++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > maxHeight)
                maxHeight = trees[i];
            if (trees[i] < minHeight)
                minHeight = trees[i];
        }
        Arrays.sort(trees);

        long left = 0, right = maxHeight;
        // 남은 나무 기준
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long cutTrees = calCutTree(mid);

            if (cutTrees >= M) {
                answer = mid;
                left = mid + 1;     // 더 높은 절단 높이 탐색
            } else {
                right = mid - 1;    // 덜 잘랐으면 더 낮게
            }
        }

        System.out.println(answer);
    }

    private static long calCutTree (long anchor) {
        long total = 0;
        for (int i = 0; i < N; i ++) {
            if (trees[i] < anchor)   continue;
            total += (trees[i] - anchor);
        }
        return total;
    }
}