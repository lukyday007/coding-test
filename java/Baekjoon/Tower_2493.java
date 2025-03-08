import java.util.*;
import java.io.*;

public class Tower_2493 {
    static int N;
    static int[] towers;

    /*
        [배운 것 1] 자료구조 Stack - 배열만 있는 줄 알았는데
                peek(), pop(), push()
        [개선] 역방향 처리 -> 정방향 처리
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        towers = new int[N];
        int[] answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && towers[stack.peek()] < towers[i]) {
//                System.out.println("stack before pop : " + Arrays.toString(stack.toArray()));
//                System.out.println("i: " + i);
                stack.pop();
//                System.out.println("stack after pop : " + Arrays.toString(stack.toArray()));
            }
            if (!stack.isEmpty()) {
//                System.out.println("stack : " + Arrays.toString(stack.toArray()));
                answer[i] = stack.peek() + 1;
            }
            stack.push(i);
//            System.out.println();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
