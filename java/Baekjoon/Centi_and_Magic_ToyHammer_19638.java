package Baekjoon;

import java.io.*;
import java.util.*;

public class Centi_and_Magic_ToyHammer_19638 {
    // 거인의 나라의 인구수 N (1 ≤ N ≤ 10^5)과 센티의 키를 나타내는 정수 Hcenti (1 ≤ Hcenti ≤ 2 × 10^9), 마법의 뿅망치의 횟수 제한 T (1 ≤ T ≤ 10^5)
    static int N, T;
    static long H;

    // N개의 줄에 각 거인의 키를 나타내는 정수 H (1 ≤ H ≤ 2 × 10^9)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 인구수 N (1 ≤ N ≤ 10^5
        H = Long.parseLong(st.nextToken());    // 센티의 키를 나타내는 정수 Hcenti (1 ≤ Hcenti ≤ 2 × 10^9)
        T = Integer.parseInt(st.nextToken());    // 마법의 뿅망치의 횟수 제한 T (1 ≤ T ≤ 10^5)

        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i ++)
            pq.offer(Long.parseLong(br.readLine()));

        int times = 0;
        while (times < T && ! pq.isEmpty() && pq.peek() >= H) {
            long tmp = pq.poll();

            if (tmp > 1) {
                tmp /= 2;
            }

            pq.offer(tmp);
            times ++;
        }

        long MaxHeight = pq.isEmpty() ? 1 : pq.peek();

        StringBuilder sb = new StringBuilder();
        if (MaxHeight < H) {
            sb.append("YES\n").append(times);
        } else {
            sb.append("NO\n").append(MaxHeight);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}