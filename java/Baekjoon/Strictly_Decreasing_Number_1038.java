import java.util.*;
import java.io.*;

public class Strictly_Decreasing_Number_1038 {

    static List<Long> answer = new ArrayList<>();

    /*
        오름차순으로 조합 만들고, 저장할 때는 내림차순으로 저장
        ex. 12, 13, 23 ... -> 21, 31, 32 저장

        이후 전체 배열에서 다시 오름차순 정렬

        [error1]
        (N >= answer.size())   // ❌ N이 size와 같을 때도 예외 발생
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 조합 구하기 : 최대 수 조합 9876543210 -> 10자리
        for (int i = 1; i <= 10; i ++) {
            combination(i, 0, new ArrayList<>());
        }

        Collections.sort(answer);
        if (N >= answer.size()) {    // ❌ N이 size와 같을 때도 예외 발생
            System.out.println(-1);
        } else if ( N >= 0 && N <= 9 ) {
            System.out.println(N);
        } else {
            System.out.print(answer.get(N));
        }
    }

    public static void combination (int depth, int start, List<Integer> arr) {
        if (arr.size() == depth) {
            List<Integer> copy = new ArrayList<>(arr);
            Collections.sort(copy, Collections.reverseOrder());

            StringBuilder sb = new StringBuilder();
            for (int num : copy)
                sb.append(num);

            answer.add(Long.parseLong(sb.toString()));
            return;
        }

        for (int i = start; i < 10; i ++) {
            arr.add(i);
            combination(depth, i + 1, arr);
            arr.remove(arr.size() - 1);
        }
    }

}
