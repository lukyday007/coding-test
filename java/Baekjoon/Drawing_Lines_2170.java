import java.util.*;
import java.io.*;
public class Drawing_Lines_2170 {
    /*
        [error]
        현재 선분과 바로 다음 선분만 비교함 → 앞에서 이어지던 더 긴 구간의 정보를 잃고, 병합 범위가 끊어져 잘못된 길이가 계산됨
        3
        1 10
        2 5
        3 4
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<long[]> arr = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken()) + 1000000000L;
            long b = Integer.parseInt(st.nextToken()) + 1000000000L;
            arr.add(new long[] { a, b });
        }
        arr.sort(Comparator.comparing(a -> a[0]));

        long answer = arr.get(0)[1] - arr.get(0)[0];
        for(int i = 0; i < N - 1; i ++) {
            // 앞 뒤로 비교
//            System.out.println(Arrays.toString(arr.get(i)));
            long[] cur = arr.get(i);
            long[] next = arr.get(i + 1);
            // 현재 범위가 다음 범위에 포함
            if (cur[1] > next[0]) {
                answer += (next[1] - cur[1]);
            } else {
                answer += (next[1] - next[0]);
            }
        }

        System.out.println(answer);
    }
}