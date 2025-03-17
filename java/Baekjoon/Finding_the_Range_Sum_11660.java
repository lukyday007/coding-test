import java.util.*;
import java.io.*;

public class Finding_the_Range_Sum_11660 {
    static int N, M;
    static int[][] board, prefix;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new int[N][N];
        prefix = new int[N + 1][N + 1];
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j ++) 
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int r = 1; r <= N; r ++) {
            for (int c = 1; c <= N; c ++) 
                prefix[r][c] = prefix[r-1][c] + prefix[r][c-1] - prefix[r-1][c-1] + board[r-1][c-1];
            
        }
        // for (int i = 0; i <= N; i ++)
        //     System.out.println(Arrays.toString(prefix[i]));

        StringBuilder sb = new StringBuilder();
        int r1, c1, r2, c2;
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());

            int answer = prefix[r2][c2] - prefix[r1 - 1][c2] - prefix[r2][c1 - 1] + prefix[r1 - 1][c1 - 1];
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
