# ver 1 -> 메모리 초과 
from collections import deque

def bfs(cr, cc, N):
   Q = deque()
   Q.append((cr, cc))
   dp = [[0] * N for _ in range(N)]
   dp[cr][cc] = 1

   while Q:
      cr, cc = Q.popleft()
      move = board[cr][cc]

      if cr == N - 1 and cc == N - 1:  # 이동 불가능한 경우
         continue    # break를 할 경우 (3, 0) 이 처리가 안됨!
   
      for r, c in ((1, 0), (0, 1)):
         nr, nc = cr + r * move, cc + c * move
         if nr < 0 or nr >= N or nc < 0 or nc >= N or dp[nr][nc]: 
            continue
         dp[nr][nc] += 1
         Q.append((nr, nc))
   
   return dp[N - 1][N - 1]

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

print(bfs(0, 0, N))


# ver 2 -> 109544kb, 96ms
N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

dp = [[0] * N for _ in range(N)]
dp[0][0] = 1

for r in range(N):
   for c in range(N):
      if dp[r][c] == 0 or board[r][c] == 0:
         continue

      move = board[r][c] 

      # 오른쪽 
      if c + move < N:
         dp[r][c + move] += dp[r][c]
      # 왼쪽
      if r + move < N:
         dp[r + move][c] += dp[r][c]

print(dp[N-1][N-1])  

