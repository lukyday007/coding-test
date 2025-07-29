package Baekjoon;

import java.util.*;
import java.io.*;

public class ATM_11399 {
    static int N;
    static List<Integer> times;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        times = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++)
            times.add(Integer.parseInt(st.nextToken()));

        times.sort((a, b) -> a - b);
        int res = 0;

        for (int i = 0; i < N-1; i ++)
            times.set(i + 1, times.get(i+1) + times.get(i));

        for (int i = 0; i < N; i ++)
            res += times.get(i);

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}