package Programmers;

public class Lv2_Target_Number {

    class Solution {
        static int N;
        static int answer = 0;

        public int solution(int[] numbers, int target) {

            N = numbers.length;
            dfs(0, 0, target, numbers);
            return answer;
        }

        private static void dfs(int depth, int total, int target, int[] numbers) {

            if (depth == N) {
                if (total == target)
                    answer ++;
                return;
            }

            dfs(depth + 1, total + numbers[depth], target, numbers);
            dfs(depth + 1, total - numbers[depth], target, numbers);
        }
    }

}
