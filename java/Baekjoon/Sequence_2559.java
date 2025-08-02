package Baekjoon;

import java.util.*;
import java.io.*;

public class Sequence_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String firstLine = br.readLine();
        StringTokenizer st = new StringTokenizer(firstLine);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] prefix = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i ++) {
            arr[i-1] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i-1] + arr[i-1];
        }

        int result = Integer.MIN_VALUE;
        for (int i = K; i <= N; i ++)
            result = Math.max(result, prefix[i] - prefix[i - K]);


        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}