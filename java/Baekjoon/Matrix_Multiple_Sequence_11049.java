package Baekjoon;

import java.util.*;
import java.io.*;

public class Matrix_Multiple_Sequence_11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < N; i ++) {
            arr.add(new ArrayList<>());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr.get(i).add(Integer.parseInt(st.nextToken()));
            arr.get(i).add(Integer.parseInt(st.nextToken()));
        }

        for (List<Integer> list : arr) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
