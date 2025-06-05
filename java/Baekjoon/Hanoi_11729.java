package Baekjoon;
import java.io.IOException;
import java.util.Scanner;

public class Hanoi_11729 {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int cnt = (int) Math.pow(2, N) - 1;
        sb.append(cnt).append("\n");

        hanoi(N, 1, 3, 2);
        System.out.println(sb);
    }

    static void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append('\n');
            return;
        }
        hanoi(n-1, from, via, to);
        sb.append(from).append(" ").append(to).append('\n');
        hanoi(n-1, via, to, from);
    }
}