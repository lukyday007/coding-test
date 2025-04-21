import java.util.*;
import java.io.*;

public class A_to_B_16953 {
    static int answer = Integer.MAX_VALUE;
    static long TARGET;
    /*
        연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        TARGET = Long.parseLong(input[1]);

        dfs(A, 1); // 연산 횟수는 1부터 시작 (자기 자신 포함)

        System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
    }

    public static void dfs(long current, int count) {
        if (current > TARGET) return;
        if (current == TARGET) {
            answer = Math.min(answer, count);
            return;
        }

        dfs(current * 2, count + 1);
        dfs(current * 10 + 1, count + 1);
    }
}