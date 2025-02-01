package PACKAGE_NAME;

import java.util.ArrayList;
import java.util.List;

public class Lv3_Sheep_And_Wolves {

    List<Integer>[] graph;
    boolean[] checked;
    int answer = 0;

    public void dfs(int node, int sheep, int wolf, int nextP, int[] info) {

        if (checked[nextP]) return ;
        checked[nextP] = true;

        if (info[node] == 0)
            sheep ++;
        else
            wolf ++;

        if (wolf > 9)
            return;

        if (wolf >= sheep)
            return;

        answer = Math.max(answer, sheep);

        for (int i = 0; i < info.length; i ++) {
            if ((nextP & (1 << i)) == 0) continue;  // and 연산으로 i번째 노드 방문 확인

            for (int nextN: graph[i])
                dfs(nextN, sheep, wolf, nextP|(1 << nextN), info);  // or 연산으로 현재 방문한 노드 nextN을 비트마스킹에 추가하여 방문기록 갱신
        }
    }

    public int solution (int[] info, int[][] edges) {

        checked = new boolean[1 << info.length];
        graph = new ArrayList[info.length];

        for (int i = 0; i < info.length; i ++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; i ++)
            graph[edges[i][0]].add(edges[i][1]);

        dfs(0, 0, 0, 1, info);

        return answer;
    }
}