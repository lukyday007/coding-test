import java.io.*;

public class Zoo_1309 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int a = 1, b = 1, c= 1;
        for (int i = 1; i < N; i ++) {
            int tmpa = (a + b + c) % 9901;
            int tmpb = (a + c) % 9901;
            int tmpc = (a + b) % 9901;

            a = tmpa; b = tmpb; c = tmpc;
        }
        int ans = a + b + c;
        System.out.println(ans % 9901);

    }
}
