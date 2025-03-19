import java.util.*;
import java.io.*;

public class Finding_the_Range_Sum4_11659 {
    static int N, M;
    static int[] arr, prefix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        prefix = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) 
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i ++) 
            prefix[i] = prefix[i-1] + arr[i - 1];
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int answer = prefix[b] - prefix[a-1];
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
