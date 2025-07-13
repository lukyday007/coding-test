package Baekjoon;

import java.util.*;
import java.io.*;

public class Cutting_LanCable_1654 {
    /*
        같은 길이의 랜선으로, N개를 만들 수 있는 랜선의 최대 길이
        1부터 최대 길이의 랜선의 범위 탐색
        => 이분탐색
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] cables = new long[K];
        long max = 0;
        for (int i = 0; i < K; i ++) {
            cables[i] = Long.parseLong(br.readLine());
            if (cables[i] > max) max = cables[i];
        }

        long left = 1;
        long right = max;
        long res = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long cnt = 0;
            for(long len: cables) {
                cnt += len/mid;
            }

            if (cnt >= N) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        System.out.println(res);
    }
}