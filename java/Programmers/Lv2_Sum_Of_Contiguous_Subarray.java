package PACKAGE_NAME;

import java.io.IOException;

public class Lv2_Sum_Of_Contiguous_Subarray {

    class Solution {
        int[] answer = new int[2];
        int sta = 0;
        int end = 0;
        int sum = 0;
        int val = 0;
        int minL = Integer.MAX_VALUE;
        public int[] solution(int[] sequence, int k) {

            while (end < sequence.length) {
                sum += sequence[end];

                while (sum >= k && sta <= end) {
                    if (sum == k) {
                        val = end - sta + 1;
                        if (val < minL) {
                            minL = val;
                            answer[0] = sta;
                            answer[1] = end;
                        }
                    }
                    sum -= sequence[sta];
                    sta ++;
                }
                end ++;
            }

            return answer;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World!");
    }
}