# 인구 이동 16234

from collections import deque
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

# Solution 1 
def bfs(sr, sc):
   Q = deque()
   Q.append((sr, sc)) 
   visit[sr][sc] = True
   arr = [(sr, sc)]
   s = board[sr][sc]

   while Q:
      cr, cc = Q.popleft()
      for d in range(4):
         nr, nc = cr + dr[d], cc + dc[d]
         if 0 <= nr < N and 0 <= nc < N and visit[nr][nc] == False:
            if L <= abs(board[cr][cc] - board[nr][nc]) <= R:
               visit[nr][nc] = True
               Q.append((nr, nc))
               arr.append((nr, nc))
               s += board[nr][nc]

   if len(arr) > 1:
      value = s // len(arr)
      for cr, cc in arr:
         board[cr][cc] = value
      
      return True
   
   return False

N, L, R = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
day = 0

while day <= 2000:
   visit = [[False] * N for _ in range(N)]
   flag1 = False
   flag2 = False
   for r in range(N):
      for c in range(N):
            if not visit[r][c]:
               flag1 = bfs(r, c)
               if flag1:
                  flag2 = flag1
                  
   if not flag2:
      break

   day += 1

print(day)


# Solution 2 => 답 O, -> 틀렸습니다...?
N, L, R = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
day = 0 
while day <= 2000:
   Q = deque()
   visit = [[0]*N for _ in range(N)]
   flag = 0

   for r in range(N):
      for c in range(N):
         if not visit[r][c]:
            Q.append((r, c))
            visit[r][c] = 1
            arr = [(r,c)]
            s = board[r][c]

            while Q:
               cr, cc = Q.popleft()
               for r, c in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                  nr, nc = cr + r, cc + c
                  if 0 <= nr < N and 0 <= nc < N and visit[nr][nc] == False and L <= abs(board[cr][cc] - board[nr][nc]) <= R:
                     Q.append((nr, nc))
                     visit[nr][nc] = 1
                     arr.append((nr, nc))
                     s += board[nr][nc]

            if len(arr) > 1:
               for r, c in arr:
                  board[r][c] = s // len(arr)
               flag = 1

   if flag == 0:
      break
   day += 1

print(day)

