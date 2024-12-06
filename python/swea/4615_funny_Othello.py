# 4615 재미있는 오셀로 게임 
dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]

for t in range(int(input())):
   N, M = map(int, input().split())
   board = [[0] * N for _ in range(N)]
   board[N//2-1][N//2-1] = board[N//2][N//2] = 2
   board[N//2-1][N//2] = board[N//2][N//2-1] = 1   

   for _ in range(M):
      cr, cc, color = map(int, input().split())
      cr -= 1
      cc -= 1
      board[cr][cc] = color

      for d in range(8):
         flips = []         
         for i in range(1, N):
            nr = cr + dr[d] * i
            nc = cc + dc[d] * i

            if 0 <= nr < N and 0 <= nc < N:     # 범위 내 
               if board[nr][nc] == 0:  break    # 빈칸 0 일 때 

               elif board[nr][nc] == color:     # 같은 돌이면 후보 뒤집기
                  while flips:                  # 이러면 돌을 놓을 곳이 없는 조건도 걸러짐 
                     r, c = flips.pop()
                     board[r][c] = color   
                  break                 
               else:
                  flips.append((nr, nc))
            else:                               # 범위 밖 
               break
      
   black = white = 0

   for r in range(N):
      for c in range(N):
         if board[r][c] == 1:
            black += 1
         elif board[r][c] == 2:
            white += 1

   print(f"#{t+1} {black} {white}")