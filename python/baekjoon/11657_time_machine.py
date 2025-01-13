# 타임머신 - 벨만 포드 
'''
벨만 - 포드
"N-1번 반복"은 모든 간선을 Relax하는 과정을 N-1번 반복한다는 뜻
N=3, M=4이므로, 각 반복에서 4개의 간선을 Relax
총 2번 반복하여 최단 경로 모든 간선을 Relax
3번째 반복에서 음수 사이클을 확인
'''

'''
첫째 줄에 도시의 개수 N (1 ≤ N ≤ 500), 버스 노선의 개수 M (1 ≤ M ≤ 6,000)
둘째 줄부터 M개의 줄에는 버스 노선의 정보 
A, B, C (1 ≤ A, B ≤ N, -10,000 ≤ C ≤ 10,000)
'''
# ver 1 
# 111400kb, 280ms 
import sys 
input = sys.stdin.readline

# N : 도시, M : 버스 노선의 개수 
N, M = map(int, input().split())
# A는 시작도시, B는 도착도시, C는 버스를 타고 이동하는데 걸리는 시간
edges = [list(map(int, input().split())) for _ in range(M)]
# C = 0인 경우는 순간 이동을 하는 경우, C < 0인 경우는 타임머신으로 시간을 되돌아가는 경우

def bellman_ford(N, M, edges):
   dist = [float('inf') for _ in range(N + 1)]
   dist[1] = 0    # 1번 도시에서 출발
   for _ in range(N - 1):  # 간선 개수 N-1번 반복 
      for s, e, t in edges:
         if dist[s] != float('inf') and  dist[e] > dist[s] + t: 
            dist[e] = dist[s] + t
         
   for s, e, t in edges:
      if dist[s] != float('inf') and  dist[e] > dist[s] + t:
         dist[0] = -1
   
   return dist

res = bellman_ford(N, M, edges)

if res[0] == -1:
   print(-1)
else:
   for r in range(2, len(res)):
      if res[r] == float("inf"):
         print(-1)   # 경로가 없는 경우 
      else:
         print(res[r])


# ver 2 - boolean으로 처리 
# 111492kb, 152ms
import sys 
input = sys.stdin.readline

INF = int(1e10)
N, M = map(int, input().split())
edges = [list(map(int, input().split())) for _ in range(M)]
dist = [INF for _ in range(N + 1)]
dist[1] = 0

cycle = False 
for i in range(N):
   for s, e, t in edges:
      if dist[s] == INF:   continue

      if dist[e] > dist[s] + t:
         dist[e] = dist[s] + t

         if i == N - 1:    # 마지박 부분에서 변화 있음 -> 음의 무한대
            cycle = True

if cycle:
   print(-1)
else:
   for i in range(2, N + 1):  # 2번 노드부터 N번 노드까지 출력
      print(dist[i] if dist[i] < INF else -1) 





