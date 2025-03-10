import java.util.*;
import java.io.*;

public class Water_Bottle_1052 {
    static int N, K;

    /*
        처음에 모든 물병에는 물이 1리터씩 들어있다
        지민이는 물병의 물을 적절히 재분배해서, K개를 넘지 않는 비어있지 않은 물병

        N=3이고, K=1일 때를 보면, 물병 3개로 1개를 만드는 것이 불가능하다.
        한 병을 또 다른 병에 부으면, 2리터가 들어있는 물병 하나와,
        1리터가 들어있는 물병 하나가 남는다.

        만약 상점에서 한 개의 물병을 산다면,
        2리터가 들어있는 물병 두 개를 만들 수 있고,
        마지막으로 4리터가 들어있는 물병 한 개

        무슨 소리인지 한참동안 고민...
        물을 동일한 양으로 균등하게 분배하는 것에 집중 X
        새로 산 물을 더해서 K 값을 벗어나지 않게 물통 줄여가기 -> 이진법
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int ans = 0;

        // Integer.bitCount(N) : N을 이진수로 변환했을 때, 1의 개수가 몇 개인지 반환
        while (Integer.bitCount(N) > K) {
            // Integer.lowestOneBit(N) : Integer.lowestOneBit(N)는 N의 이진수에서 가장 오른쪽에 있는 1 비트만 반환
            // binary 111'1' -> + 1, binary 11'1'0 -> + 2
            ans += Integer.lowestOneBit(N);
            N += Integer.lowestOneBit(N);
        }

        System.out.println(ans);
    }
}
