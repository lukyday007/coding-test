import java.util.*;
import java.io.*;

public class Minimum_and_Maximum_2357 {
    static int N, M;
    static int[] numbers;
    static int[][] input;

    /*
        SegmentTree
        - prefix sum
        - max value
        - min value
    */
    static class SegmentTree {
        int[] arr, treeMax, treeMin;

        public SegmentTree(int[] input) {
            arr = input;
            int n = input.length;
            treeMax = new int[n * 4];
            treeMin = new int[n * 4];
            build(1, 0, n - 1);
        }

        private void build(int node, int start, int end) {
            if (start == end) {
                treeMax[node] = arr[start];
                treeMin[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                build(node * 2, start, mid);
                build(node * 2 + 1, mid + 1, end);

                treeMax[node] = Math.max(treeMax[node * 2], treeMax[node * 2 + 1]);
                treeMin[node] = Math.min(treeMin[node * 2], treeMin[node * 2 + 1]);
            }
        }

        public int queryMax(int node, int start, int end, int left, int right) {
            // 범위 벗어나는 경우
            if (right < start || end < left)    return Integer.MIN_VALUE;
            if (left <= start && end <= right)  return treeMax[node];

            int mid = (start + end) / 2;
            int l = queryMax(node * 2, start, mid, left, right);
            int r = queryMax(node * 2 + 1, mid + 1, end, left, right);

            return Math.max(l, r);
        }

        public int queryMin(int node, int start, int end, int left, int right) {
            // 범위 벗어나는 경우
            if (right < start || end < left)    return Integer.MAX_VALUE;
            if (left <= start && end <= right)  return treeMin[node];

            int mid = (start + end) / 2;
            int l = queryMin(node * 2, start, mid, left, right);
            int r = queryMin(node * 2 + 1, mid + 1, end, left, right);

            return Math.min(l, r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        for (int i = 0; i < N; i ++)
            numbers[i] = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        SegmentTree seg = new SegmentTree(numbers);
        int maxVal = Integer.MIN_VALUE, minVal = Integer.MAX_VALUE;
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            maxVal = seg.queryMax(1, 0, N-1, a-1, b-1);
            minVal = seg.queryMin(1, 0, N-1, a-1, b-1);
            sb.append(minVal).append(" ").append(maxVal).append("\n");
        }
        System.out.println(sb);
    }
}