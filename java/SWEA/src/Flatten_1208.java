import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Flatten_1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i ++) {
            int cnt = Integer.parseInt(br.readLine());
            int[] arr = new int[100];   // 가로 길이

            StringTokenizer tr = new StringTokenizer(br.readLine());
            for (int j = 0; j < 100; j++) {
                arr[j] = Integer.parseInt(tr.nextToken());
            }

            for (int k = 0; k < cnt; k ++) {
                Arrays.sort(arr);
                arr[99] --;
                arr[0] ++;
            }

            Arrays.sort(arr);
            int ans = arr[99] - arr[0];
            System.out.println("#" + (i + 1) + " " + ans);
        }
    }
}
