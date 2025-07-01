package Programmers;
import java.util.*;

public class Lv3_Stock_Price {
    class Solution {
        public int[] solution(int[] prices) {
            int n = prices.length;
            int[] answer = new int[n];
            Deque<Integer> st = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && prices[i] < prices[st.peek()]) {
                    int sec = st.pop();
                    answer[sec] = i - sec;
                }
                st.push(i);
            }

            while (!st.isEmpty()) {
                int sec = st.pop();
                answer[sec] = n - 1 - sec;
            }

            return answer;
        }
    }
}