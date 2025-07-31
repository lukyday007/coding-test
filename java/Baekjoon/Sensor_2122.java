package Baekjoon;

import java.util.*;
import java.io.*;
public class Sensor_2122 {
    static int N, K;
    static int[] centers;
    /*
        [way] 차이가 큰 곳에는 센서를 세우지 않는다
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        centers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++)
            centers[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(centers);

        int[] gaps = new int[N-1];
        int idx = 0;
        for (int i = 0; i < N-1; i ++) {
            if (centers[i + 1] == centers[i]) continue;
            gaps[idx++] = centers[i + 1] - centers[i];
        }
        Arrays.sort(gaps);

        int sum = 0;
        for (int i = 0; i < N - K; i ++)
            sum += gaps[i];

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}