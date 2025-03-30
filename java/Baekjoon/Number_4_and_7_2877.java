import java.util.*;
import java.io.*;

public class Number_4_and_7_2877 {
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        if (K <= 2) {
            String answer = K == 1 ? "4" : "7";
            System.out.println(answer);
            return;
        }

        // 첫째 항이 2 인 (4, 7)인 공비수열의 합 = 10 ^ 9
        // 최대 깊이 30 => 트리로 해결 -> 완전 이진트리
        // 깊이 구하기
        int depth = (int) Math.ceil(Math.log(K + 2) / Math.log(2)) - 1;
//        System.out.println(depth);

        int totalNodes = 1 << depth;    // 해당 깊이의 총 노드 수
        int seq = K - totalNodes + 2;
        String bitmask = String.format("%" + depth + "s", Integer.toBinaryString(seq - 1)).replace(' ', '0');

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bitmask.length(); i ++) {
            char bit = bitmask.charAt(i);
//            System.out.println("bit: " + bit);
            if (bit == '0')
                sb.append("4");
            else
                sb.append("7");
        }
        sb.append("\n");
        System.out.println(sb);
    }
}