import java.util.*;
import java.io.*;

public class Conveyor_Belt_Sushi_28107 {
    static int N, M;
    static int[] sushi, cus;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cus = new int[N];
        sushi = new int[M];
        HashMap<Integer, Queue<Integer>> wishMap = new HashMap<>();

        // 고객별로 원하는 초밥 리스트를 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int wannaEat = Integer.parseInt(st.nextToken());

            for (int j = 0; j < wannaEat; j++) {
                int s = Integer.parseInt(st.nextToken());
                wishMap.putIfAbsent(s, new LinkedList<>());
                wishMap.get(s).offer(i);
            }
        }

        // 초밥 배열 (순서 유지 필요)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sushi[i] = Integer.parseInt(st.nextToken());
        }

        // 초밥 배열 순서대로 고객에게 배분
        for (int i = 0; i < M; i++) {
            int sushiType = sushi[i];

            if (wishMap.containsKey(sushiType)) {
                Queue<Integer> queue = wishMap.get(sushiType);

                if (!queue.isEmpty()) {
                    int customerIndex = queue.poll();  // 초밥을 원하는 고객 배정
                    cus[customerIndex]++;
                    sushi[i] = 0;  // 해당 초밥은 사용 처리
                }
            }
        }

        // 결과 출력
        for (int a = 0; a < N; a++) {
            System.out.print(cus[a] + " ");
        }
    }
}
