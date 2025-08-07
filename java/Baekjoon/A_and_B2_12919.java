package Baekjoon;

import java.io.*;
public class A_and_B2_12919 {
    static String from, to;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        from = br.readLine();
        to = br.readLine();

        int limit = to.length() - from.length();
        backtracking(limit, 0, to);

        bw.write(String.valueOf(flag ? 1 : 0));
        bw.flush();
        bw.close();
    }

    private static void backtracking(int limit, int depth, String cur) {
        if (flag)   return;

        if (depth == limit) {
            // to ---> from 비교
            if (cur.equals(from)) flag = true;
            return;
        }

        // 가능한 경우만 선택해서 재귀
        // --- A
        if (cur.charAt(cur.length() - 1) == 'A')
            backtracking(limit, depth + 1, cur.substring(0, cur.length() - 1));

        // --- B
        if (cur.charAt(0) == 'B') {
            String reversed = new StringBuilder(cur.substring(1)).reverse().toString();
            backtracking(limit, depth + 1, reversed);
        }
    }
}