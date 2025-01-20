# 특정한 최단 경로 
'''
세준이는 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다. 
하지만 반드시 최단 경로로 이동해야 한다는 사실에 주의
1번 정점에서 N번 정점으로 이동할 때, 주어진 두 정점을 반드시 거치면서 최단 경로로 이동

4 6
1 3 1
2 3 1
3 4 1
1 2 3
2 4 6
1 4 4
2 3

4 2
1 4 4
2 3 1
2 3
'''
# ver 1 - 다익스트라 
# try 1 - -1인 경우를 처리안해서 75%에서 틀림 
# 125444kb, 260ms

import sys, heapq

input = sys.stdin.readline
N, E = map(int, input().split())
graph = [[] for _ in range(N + 1)]
for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

point1, point2 = map(int, input().split())
INF = int(1e9)

def dijkstra(sta):
    dist = [INF for _ in range(N + 1)]
    visit = [0 for _ in range(N + 1)]
    dist[sta] = 0
    visit[sta] = 0
    hq = []
    heapq.heappush(hq, (0, sta))

    while hq:
        cost, newN = heapq.heappop(hq)

        if dist[newN] < cost:   continue

        for g in graph[newN]:
            if cost + g[1] >= dist[g[0]]:   continue

            dist[g[0]] = cost + g[1]
            visit[g[0]] = newN
            heapq.heappush(hq, (cost + g[1], g[0]))

    return dist

ans = -1
minV = INF 
dist1 = dijkstra(point1) 
dist2 = dijkstra(point2)

# 1 - point1 - point2 - N
# 1 - point2 - point1 - N
minV = min(dist1[1] + dist1[point2] + dist2[N], dist1[N] + dist2[point1] + dist2[1])
print(minV if minV < INF else ans)
