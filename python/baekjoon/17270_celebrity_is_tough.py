# 연예인은 힘들어 
'''
1. 지헌이의 출발 위치와 성하의 출발 위치는 새로운 약속 장소가 될 수 없다.
2. 성품도 훌륭한 지헌이는 새로운 약속 장소는 지헌이가 걸리는 최단 시간과 성하가 걸리는 최단 시간의 합이 최소가 되도록 하고 싶다.
3. 지헌이가 더 늦게 도착하면 성하에게 안좋은 소리를 들을 것이 뻔하기에, 1번과 2번 조건을 만족하는 장소 중에서도 지헌이가 성하보다 늦게 도착하는 곳은 약속 장소가 될 수 없다.
4. 위의 세 조건을 모두 만족하는 약속 장소가 여러 곳이 있다면, 그 중에 지헌이로부터 가장 가까운 곳이 최종 약속 장소가 된다. 그런 장소도 여러 곳이 있다면, 그 중에 번호가 가장 작은 장소가 최종 약속 장소가 된다.

약속 장소 후보의 수 V와 약속 장소를 연결하는 총 길의 수 M
(2 ≤ V ≤ 100, 1 ≤ M ≤ 1,000)
다음 M개의 => a, b는 길의 시작과 끝이며 c는 그 길을 지나가는 데 걸리는 시간
(1 ≤ a, b ≤ V, c는 10,000이하의 자연수, 길은 양방향이다)
다음 줄에는 지헌이의 위치 J 와 성하의 위치 S  (1 ≤ J, S ≤ V)
'''
# ver 1 - 플로이드 워셜 
# 112076kb, 148ms
import sys 

# input = sys.stdin.readline
# V, M = map(int, input().split())
# INF = float("inf")
# graph = [[INF for _ in range(V + 1)] for _ in range(V + 1)]

# for _ in range(M):
#     a, b, c = map(int, input().split())
#     if c < graph[a][b]:     # 간선 중복 방지 
#         graph[a][b] = c     # 양방향 바인딩 
#         graph[b][a] = c

# # 플로이드 - 워셜 실행 : 모든 노드 간 최단 경로 구하기 
# for v in range(1, V + 1):
#     graph[v][v] = 0
#     for a in range(1, V + 1):
#         for b in range(1, V + 1):
#             graph[a][b] = min(graph[a][b], graph[a][v] + graph[v][b])

# J, S = map(int, input().split())

# total = INF 
# for i in range(1, V + 1):
#     # 1. 지헌이의 출발 위치와 성하의 출발 위치는 새로운 약속 장소가 될 수 없다
#     if i == J or i == S:    continue 
#     tmp = graph[J][i] + graph[S][i]

#     # 2. 최단 시간의 합이 최소가 아닌 경우 가지치기
#     if tmp > total:     continue 
#     total = tmp 

# place = []
# dist = INF
# ans = -1
# for i in range(V, 0, -1):
#     if i == J or i == S:    continue

#     # 3. 지헌이가 성하보다 늦게 도착하는 곳은 약속 장소가 될 수 없다
#     if graph[J][i] > graph[S][i]:   continue

#     if graph[J][i] + graph[S][i] == total:
#         # 4. 지헌이로부터 가장 가까운 곳이 최종 약속 장소가 된다. 그 중에 번호가 가장 작은 장소가 최종 약속 장소
#         if graph[J][i] < dist:
#             dist = graph[J][i]
#             ans = i

# print(ans)


# ver 2 - 다익스트라 
# 110996kb, 112ms
import heapq

input = sys.stdin.readline
V, M = map(int, input().split())
INF = int(1e9)
graph = [[] for _ in range(V + 1)]

for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

J, S = map(int, input().split())

def dijkstra(sta):
    dist = [INF for _ in range(V + 1)]
    hq = []
    heapq.heappush(hq, (0, sta))   # 가중치, 노드 번호 순 
    dist[sta] = 0
     
    while hq:
        cost, newN = heapq.heappop(hq)
        if dist[newN] < cost:   continue

        for g in graph[newN]:
            # 그래프에 저장할 때는 노드 - 가중치 순 
            if cost + g[1] >= dist[g[0]]:   continue

            dist[g[0]] = cost + g[1]
            heapq.heappush(hq, (cost + g[1], g[0]))
    
    return dist

distJ = dijkstra(J)
distS = dijkstra(S)

minV = INF
for i in range(1, len(distJ)):
    if i == J or i == S: continue
        
    if distJ[i] + distS[i] > minV:  continue
    minV = distJ[i] + distS[i]

ans = -1
res = INF
for i in range(len(distJ) - 1, 0, -1):
    if i == J or i == S:  continue
        
    if distJ[i] > distS[i]:     continue

    if distJ[i] + distS[i] == minV:
        if distJ[i] < res:
            res = distJ[i]
            ans = i
            
print(ans)