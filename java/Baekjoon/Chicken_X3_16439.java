import java.util.*;
import java.io.*;

public class Chicken_X3_16439 {
    static int N, M;
    static int[][] chickens;
    static int answer = Integer.MIN_VALUE;

    /*
        치킨 종류 중 3개 구하기... -> 조합
    */

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chickens = new int[N][M];

        for (int r = 0; r < N; r ++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c ++) {
                chickens[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0, new int[3]);
        System.out.println(answer);
    }

    public static void combination(int depth, int idx, int[] types) {

        if (depth == 3) {
//            System.out.println(Arrays.toString(types));
            int sum = 0;
            for (int i = 0; i < N; i ++) {
                int maxVal = 0;
                for (int type : types)
                    maxVal = Math.max(maxVal, chickens[i][type]);
                sum += maxVal;
            }
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = idx; i < M; i ++) {
            types[depth] = i;
            combination(depth + 1, i + 1, types);
        }
    }
}