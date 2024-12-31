# 석유 시추 

# ver 1 - bfs - 정확성 O, 효율성 X
from collections import deque
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

def solution(land):
   R = len(land)
   C = len(land[0])
   maxV = 0 

   def bfs(pos, R, C):
      visit = [[0 for _ in range(C)] for _ in range(R)]
      Q = deque()

      for r in range(R):
         if land[r][pos]:
            visit[r][pos] = 1
            Q.append((r, pos))

      oil = 0

      while Q:
         cr, cc = Q.popleft()
         if land[cr][cc]:
            oil += 1

         for d in range(4):
            nr, nc = cr + dr[d], cc + dc[d] 
            if nr < 0 or nr >= R or nc < 0 or nc >= C: continue
            if land[nr][nc] and visit[nr][nc] == 0:
               Q.append((nr, nc))
               visit[nr][nc] = 1

      return oil

   for c in range(C):
      val = bfs(c, R, C)
      maxV = max(val, maxV)
   
   return maxV


# ver 2 : 석유만 모여있는 배열을 따로 생성 - 정확성 O, 효율성 X 
from collections import deque
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

def solution(land):
   R = len(land)
   C = len(land[0])
   oil = [(r, c) for r in range(R) for c in range(C) if land[r][c] == 1]
   maxV = 0 

   def bfs(pos, R, C):
      visit = [[False for _ in range(C)] for _ in range(R)]
      Q = deque()

      for r, c in oil:
         if c == pos:
            visit[r][pos] = True
            Q.append((r, pos))

      amount = 0

      while Q:
         cr, cc = Q.popleft()
         if land[cr][cc]:
            amount += 1

         for d in range(4):
            nr, nc = cr + dr[d], cc + dc[d] 
            if nr < 0 or nr >= R or nc < 0 or nc >= C: continue
            if land[nr][nc] and visit[nr][nc] == False:
               Q.append((nr, nc))
               visit[nr][nc] = 1

      return amount

   for c in range(C):
      maxV = max(bfs(c, R, C), maxV)
   
   return maxV


# ver 3 : 가장 중요한 생각은 2차원으로 생각하는 것이 아닌 1차원으로 생각
from collections import deque
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

def solution(land):
   R = len(land)
   C = len(land[0])
   result = [0 for _ in range(C)]
   visit = [[False for _ in range(C)] for _ in range(R)]

   def bfs(sr, sc):
      Q = deque()
      Q.append((sr, sc))
      visit[sr][sc] = True
      minC, maxC = sc, sc 
      amount = 0

      while Q:
         cr, cc = Q.popleft()
         minC = min(minC, cc)
         maxC = max(maxC, cc)
         amount += 1

         for d in range(4):
            nr, nc = cr + dr[d], cc + dc[d] 
            if nr < 0 or nr >= R or nc < 0 or nc >= C: continue
            if land[nr][nc] and visit[nr][nc] == False:
               Q.append((nr, nc))
               visit[nr][nc] = 1
      
      # print(f"minC, maxC : {minC}, {maxC}")
      for i in range(minC, maxC + 1):
         result[i] += amount

      return amount

   for r in range(R):
      for c in range(C):
         if land[r][c] == 1 and visit[r][c] == False:
            bfs(r, c)
   # print(result)
   return max(result)





