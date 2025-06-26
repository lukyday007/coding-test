package Programmers;
import java.util.*;

public class Lv3_Trip_Route {

    class Solution_DFS {
        static List<String> answer = new ArrayList<>();
        static boolean[] visited;

        public String[] solution(String[][] tickets) {
            Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1])); // 도착지 기준 알파벳 정렬
            visited = new boolean[tickets.length];
            List<String> route = new ArrayList<>();
            route.add("ICN");

            dfs("ICN", route, tickets, 0);

            return answer.toArray(new String[0]);
        }

        private boolean dfs(String current, List<String> route, String[][] tickets, int depth) {
            if (depth == tickets.length) {
                answer = new ArrayList<>(route);
                return true;
            }

            for (int i = 0; i < tickets.length; i++) {
                if (!visited[i] && tickets[i][0].equals(current)) {
                    visited[i] = true;
                    route.add(tickets[i][1]);

                    if (dfs(tickets[i][1], route, tickets, depth + 1)) {
                        return true;
                    }

                    route.remove(route.size() - 1);
                    visited[i] = false;
                }
            }

            return false;
        }
    }
}