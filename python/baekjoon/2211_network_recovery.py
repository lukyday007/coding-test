# 네트워크 복구 
# 136560kb, 316ms 
'''
# 다익스트라 공부 - heapq 사용 
import heapq

def dijkstra(sta, graph, n):
   dist = [int(1e9) for _ in range(n+1)]
   dist[sta] = 0

   priorityQ = [(0, sta)]

   while priorityQ:
      curDist, curNode = heapq.heappop(priorityQ)

      # 이미 최단거리 측정 완료 -> 스킵 
      if curDist > dist[curNode]:   continue 

      for neighbor, weight in graph(curNode):
         dist = curDist + weight 

         if dist < dist[neighbor]:
            dist[neighbor] = dist
            heapq.heappush(priorityQ, (dist, neighbor))
   
   return dist 
'''

import heapq

# 최소 개수의 회선만 복구 -> 서로 다른 두 컴퓨터간 통신 가능하게 
# 슈퍼 컴퓨터와 다른 컴퓨터와 통신하는 시간은 최소시간 -> 원래 통신 시간보다 커지면 안됨 
def dijkstra(sta, graph, n):
   dist = [int(1e9) for _ in range(n + 1)]
   dist[sta] = 0
   visit = [0] * (n + 1)

   priQ = [(0, sta)]    # 슈퍼컴퓨터가 시작점 

   while priQ:
      curD, curN = heapq.heappop(priQ)
      print(f"curN - {curN}, curD - {curD}")
      
      if curD > dist[curN]:   continue

      for newN, d in graph[curN]:
         dis = curD + d 

         if dis < dist[newN]:

            print(f"newN - {newN}, d - {d}")

            dist[newN] = dis
            visit[newN] = curN
            print(f"dis - {dis}, dist - {dist}")
            heapq.heappush(priQ, (dis, newN))

   print(f"dist: {dist}")
   return visit 

# 입력 조건 
# N : 컴퓨터 개수 , M : 회선 수 
N, M = map(int, input().split())
# A번 컴퓨터와 B번 컴퓨터가 통신 시간이 C (1 ≤ C ≤ 10)인 회선으로 연결
graph = [[] for _ in range(N + 1)]  # 양방향 그래프 생성 
for _ in range(M):
   a, b, c = map(int, input().split())
   graph[a].append((b, c))
   graph[b].append((a, c))

# 슈퍼 컴퓨터와 나머지 컴퓨터들이 최단 거리로 연결되어야함 
res = dijkstra(1, graph, N)

print(N-1)
for i in range(2, N + 1):
   print(i, res[i])



