import java.util.*;
import java.io.*;

public class Jewel_Thief_1202 {
    static int N, K;
    static int[] bags;
    static JewelValue[] jewels;
    static long maxVal = 0;

    /*
            가방에는 최대 한 개의 보석만 넣을 수 있다.

            [error 1] pq1, pq2 두 개 사용 -> 시간 초과
            [solution]  보석의 가치 기준으로만 우선순위큐 저장
            [error 2] 가치 범위 0 ≤ Mi, Vi ≤ 1,000,000
            [solution]  long 타입 변경
    */

    public static class JewelValue {
        int weight, value;
        JewelValue(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void getMaxValue( int[] bags) {
        // reverseOrder() : 내림차순
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int jewelIdx = 0;

        for (int bag : bags) {
//            System.out.println("bag : " + bag);
            while (jewelIdx < N && bag >= jewels[jewelIdx].weight) {
//                System.out.println("jewel weight : " + jewels[jewelIdx].weight + " , jewel value : " + jewels[jewelIdx].value);
                pq.offer(jewels[jewelIdx].value);
                jewelIdx ++;
            }

            if (! pq.isEmpty()) {
                int value = pq.poll();
                maxVal += value;    // 가치 기준 내림차순으로 나온 보석
//                System.out.println("jewel value : " + value);
            }
        }
    }

    public static void main(String[] args) throws  IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewels = new JewelValue[N];
        bags = new int[K];

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new JewelValue(w, v);
        }

        // 무게 기준 오름차순
        Arrays.sort(jewels, (a, b) -> Integer.compare(a.weight, b.weight));

        for (int i = 0; i < K; i ++)
            bags[i] = Integer.parseInt(br.readLine());

        Arrays.sort(bags);
        getMaxValue(bags);
        System.out.println(maxVal);

        /*

4 3
2 3
2 1
3 5
3 6
3
3
3


답:14
         */
    }
}
