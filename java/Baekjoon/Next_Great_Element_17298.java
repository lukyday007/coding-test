package Baekjoon;

import java.util.*;
import java.io.*;

public class Next_Great_Element_17298 {
    static int N;
    static int[] arr, result, stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        stack = new int[N];
        result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i ++)
            arr[i] = Integer.parseInt(st.nextToken());

        int idx = -1;
        for (int i = 0; i < N; i ++) {
            while (idx >= 0 && arr[stack[idx]] < arr[i]) {
                result[stack[idx--]] = arr[i];
            }
            stack[++idx] = i;
        }

        while (idx >= 0) {
            int tmp = stack[idx--];
            result[tmp] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i ++)
            sb.append(result[i]).append(" " );

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}