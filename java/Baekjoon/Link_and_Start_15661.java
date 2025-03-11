import java.util.*;
import java.io.*;

public class Link_and_Start_15661 {
    static int N;
    static int[][] board;
    static int minVal = Integer.MAX_VALUE;

    /*
        두 팀의 인원수는 같지 않아도 되지만, 한 명 이상
        스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로
    */
    public static int calMinVal(int bitmask) {
        int start = 0, link = 0;

        if (Integer.bitCount(bitmask) == 0 || Integer.bitCount(bitmask) == N) {
//            System.out.println("all member in one team");
            return Integer.MAX_VALUE;
        }

        for (int i = 0; i < N; i ++) {
            for (int j = i + 1; j < N; j ++) {
                if ((bitmask & (1 << i)) != 0 && (bitmask & (1 << j)) != 0) {
//                    System.out.println("!= " + bitmask + ": " + Integer.toBinaryString(bitmask) + ", 1 << " + i + "(" + (1<<i) + "): " + (bitmask & (1 << i)) + " , 1 << " + j + "(" + (1<<j) + ") : " + (bitmask & (1 << j)));
                    start += (board[i][j] + board[j][i]);

                } else if ((bitmask & (1 << i)) == 0 && (bitmask & (1 << j)) == 0) {
//                    System.out.println("== " + bitmask + ": " + Integer.toBinaryString(bitmask) + ", 1 << " + i + "(" + (1<<i) + "): " + (bitmask & (1 << i)) + " , 1 << " + j + "(" + (1<<j) + ") : " + (bitmask & (1 << j)));
                    link += (board[i][j] + board[j][i]);
                }
            }
        }

//        System.out.println("start: " + start + ", link : " + link);
//        System.out.println();

        return Math.abs(start - link);
    }

    public static void backtracking(int depth, int bitmask) {
        if (depth == N) {
            minVal = Math.min(minVal, calMinVal(bitmask));
            return;
        }

//        System.out.println("depth : " + depth + " first before bitmask : " + bitmask);
        backtracking(depth + 1, bitmask);
//        System.out.println("depth : " + depth + " first after bitmask : " + bitmask);

//        System.out.println("depth : " + depth + " second before bitmask : " + (bitmask | (1 << depth)));
        backtracking(depth + 1, bitmask | (1 << depth));
//        System.out.println("depth : " + depth + " second after bitmask : " + (bitmask | (1 << depth)));
    }

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j ++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(Integer.toBinaryString(1<<0));
//        System.out.println(Integer.toBinaryString(1<<1));
//        System.out.println(Integer.toBinaryString(1<<2));
//        System.out.println(Integer.toBinaryString(1<<3));
//        System.out.println(Integer.toBinaryString(1<<4));
//        System.out.println(1<<4 - 1);

        backtracking(0, 0);
        System.out.println(minVal);

    }
}
