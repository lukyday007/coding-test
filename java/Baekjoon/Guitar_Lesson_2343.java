import java.util.*;
import java.io.*;

public class Guitar_Lesson_2343 {
    static int N, M;
    static int[] lessons;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lessons = new int[N];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i ++) {
            int time = Integer.parseInt(st.nextToken());
            lessons[i] = time;
            sum += time;
            max = Math.max(time, max);
        }

        int l = max, r = sum;
        int answer = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (r + l) / 2;
            int chucks = getBluRayNumber(mid);

            if (chucks > M)
                l = mid + 1;
            else {
                answer = mid;
                r = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static int getBluRayNumber(int mid) {
        int result = 1;
        int total = 0;
        for (int i = 0; i < N; i ++) {
            if (total + lessons[i] > mid) {
                result ++;
                total = lessons[i];
            } else {
                total += lessons[i];
            }
        }
//        System.out.println("mid : " + mid + " , chunks : " + result);
        return result;
    }
}