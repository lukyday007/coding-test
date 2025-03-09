import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Jewel_Thief_1202_Optimization {
    static int N, K;
    static long maxVal = 0;

    /*
            가방에는 최대 한 개의 보석만 넣을 수 있다.
    */

    public static class JewelValue {
        int weight, value;
        JewelValue(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws  IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // jewels : 무게 기준 오름차순
        PriorityQueue<JewelValue> jewels = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        // values : 가치 기준 내림차순
        PriorityQueue<Integer> values = new PriorityQueue<>((a, b) -> b - a);
        // 우선순위 큐 : 기본 오름차순
        PriorityQueue<Integer> bags = new PriorityQueue<>();

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            jewels.add(new JewelValue(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        for (int i = 0; i < K; i ++)
            bags.add(Integer.parseInt(br.readLine()));

        while (! bags.isEmpty()) {
            int bag = bags.poll();

            while (! jewels.isEmpty() && bag >= jewels.peek().weight)
                values.add(jewels.poll().value);

            if (! values.isEmpty())
                maxVal += values.poll();
        }

        System.out.println(maxVal);
    }
}
