import java.util.*;
import java.io.*;

public class Sorting_Cards_1715 {
    static int N;
    static int answer = 0;  // 최소한 몇 번의 비교가 필요한지

    /*
        [ sort + dfs ] -> O(nlogn) + O(N^100000) => 시간초과
        [ 우선순위 큐 ] -> O(nlogn)
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i ++)
            pq.offer(Integer.parseInt(br.readLine()));

        // N ≥ 1이고, 항상 "카드를 비교해야" 하는 상황
        while (pq.size() > 1) {     // 이 조건절에서 다 필터링 되기 때문에 isEmpty() 확인 X
            int a = 0, b = 0;
            a = pq.poll();
            b = pq.poll();

            answer += (a + b);
            pq.offer(a + b);
        }

        System.out.println(answer);
    }
}