import java.util.*;
import java.io.*;

public class Longest_Increasing_Subsequence2_12015 {
    static int N;
    // static List<Integer> check; // 시간 초과 원인! 
    static int[] LIS;

    /*
        [ error 1] ArrayList 시간초과! -> array 수정 
    */
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // check = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        // check.add(Integer.parseInt(st.nextToken()));
        // int target = check.get(check.size()-1);

        LIS = new int[N];
        int SIZE = 0;

        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());

            if (SIZE == 0 || LIS[SIZE - 1] < key) {
                LIS[SIZE] = key;
                SIZE++;
            } else {
                int idx = binarySearch(LIS, key, SIZE);
                LIS[idx] = key;
            }
        }

        System.out.println(SIZE);
    }

    public static int binarySearch(int[] LIS, int key, int size) {
        int l = 0, r = size - 1;
        System.out.println(Arrays.toString(LIS));
        System.out.println("key: " + key + ", size: " + size);

        while (l <= r) {
            int mid = (l + r) / 2;
            System.out.println("Binary search - l: " + l + ", r: " + r + ", mid: " + mid);

            if (LIS[mid] < key) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println();

        return l;
    }

    // public static int binarySearch(List<Integer> LIS, int key) {
    //     int l = 0;
    //     int r = LIS.size()-1;

    //     while (l <= r) {
    //         int mid = (l + r) / 2;
    //         if (LIS.get(mid) >= key)    // key 보다 크다면 탐색범위를 왼쪽
    //             r = mid;
    //         else    // key 보다 작다면 탐색범위를 오른쪽 
    //             l = mid + 1;
    //     }

    //     return l;    
    // }
}
