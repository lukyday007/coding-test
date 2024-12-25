# 새로운 게임 
# 체스판의 크기 N, 말의 개수 K 
# 0은 흰색, 1은 빨간색, 2는 파란색 
# 1부터 순서대로 →, ←, ↑, ↓

'''
하나의 말 위에 다른 말을 올릴 수 있다
한 말이 이동할 때 위에 올려져 있는 말도 함께 이동하며, 가장 아래에 있는 말만 이동할 수 있다

흰색인 경우에는 그 칸으로 이동한다. 이동하려는 칸에 말이 이미 있는 경우에는 가장 위에 A번 말을 올려놓는다.
빨간색인 경우에는 이동한 후에 A번 말과 그 위에 있는 모든 말의 쌓여있는 순서를 반대로 바꾼다
파란색인 경우에는 A번 말의 이동 방향을 반대로 하고 한 칸 이동한다. 방향을 반대로 한 후에 이동하려는 칸이 파란색인 경우에는 이동하지 않고 방향만 반대로 바꾼다.

말의 정보는 세 개의 정수로 이루어져 있고, 순서대로 행, 열의 번호, 이동 방향

dir - {1: 1, 2: 3, 3: 1, 4: 2}

턴이 진행되던 중에 말이 4개 이상 쌓이는 순간 게임이 종료
'''
# 1부터 순서대로 →, ←, ↑, ↓
from collections import deque
dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]

def change_direction(d):
   if d == 0:
      return 1
   elif d == 1:
      return 0
   elif d == 2:
      return 3
   else:
      return 2 

def check_limit(r, c):
   if len(check[r][c]) >= 4:
      print("length is over 4!!!!!!!!!!")
      return True
   return False 
   

# 체스판의 크기 N, 말의 개수 K
N, K = map(int, input().split())
# 0은 흰색, 1은 빨간색, 2는 파란색
board = [list(map(int, input().split())) for _ in range(N)]
pieces = [list(map(int, input().split())) for _ in range(K)]
check = [[[] for r in range(N)] for c in range(N)]
dir = dict()

for i in range(len(pieces)):
   for j in range(3):
      pieces[i][j] -= 1

for i in range(len(pieces)):
   dir[i + 1] = pieces[i][2] 

# 말 셋팅 
for i in range(len(pieces)):
   check[pieces[i][0]][pieces[i][1]] = [i + 1]

for r in range(N):
   print(check[r])
print()

turn = 1
while turn <= 1000:
   flag = True


   for idx, piece in enumerate(pieces):
      # print(idx, piece)
      r, c, d = piece[0], piece[1], dir[idx + 1]
      # print(r, c, d)
      if check[r][c][0] != idx + 1: continue    # 맨 아래 돌만 이동

      nr, nc = r + dr[d], c + dc[d]
      if nr < 0 or nr >= N or nc < 0 or nc >= N: # 범위 벗어날 때 
         # print("범위 벗어났을 때")
         # 파란색과 같은 기능 설정 
         nd = change_direction(d)
         dir[idx + 1] = nd        # 기존 저장된 방향 갱신 
         newr, newc = r + dr[nd], c + dc[nd]
         if newr < 0 or newr >= N or newc < 0 or newc >= N: continue

         if board[newr][newc] == 0:    # 이후 이동한 곳이이 흰색
            # print("범위 벗어났을 때 흰색")
            check[newr][newc].extend(check[r][c])
            for pos in check[newr][newc]:     # 이동한 말 위치 갱신 
               pieces[pos-1] = [newr, newc, pieces[pos-1][2]]
            check[r][c] = []

            if check_limit(newr, newc):
               flag = False
               break
               
         elif board[newr][newc] == 1:  # 이후 이동한 곳이 빨간색
            # 해당 말과 그 위의 모든 말의 순서를 바꾸기 
            # print("범위 벗어났을 때 빨강")
            check[r][c].reverse()
            print("reverse")
            print(check[r][c])
            check[newr][newc].extend(check[r][c])
            for pos in check[newr][newc]:     # 이동한 말 위치 갱신 
               pieces[pos-1] = [newr, newc, pieces[pos-1][2]]
            check[r][c] = []

            if check_limit(newr, newc):
               flag = False   
               break

         else:                         # 이후 이동한 곳이 파란색             
            continue    # 이동하지 않음
         
      else: 
         if board[nr][nc] == 0:     # 흰색 
            # print("흰색 ")
            check[nr][nc].extend(check[r][c])
            for pos in check[nr][nc]:     # 이동한 말 위치 갱신 
               # print(f"check[{nr}][{nc}] : {check[nr][nc]}")
               pieces[pos-1] = [nr, nc, pieces[pos-1][2]]
            check[r][c] = []

            if check_limit(nr, nc):
               flag = False
               break

         elif board[nr][nc] == 1:   # 빨간색
            # print("빨간색 ")
            # 해당 말과 그 위의 모든 말의 순서를 바꾸기 
            print(check[r][c])
            check[r][c].reverse()
            print("reverse")
            print(check[r][c])
            check[nr][nc].extend(check[r][c])
            for pos in check[nr][nc]:     # 이동한 말 위치 갱신 
               pieces[pos-1] = [nr, nc, pieces[pos-1][2]]
            check[r][c] = []

            if check_limit(nr, nc):
               flag = False
               break

         else:                      # 파란색
            # print("파란색 ") 
            nd = change_direction(d)
            dir[idx + 1] = nd        # 기존 저장된 방향 갱신 
            newr, newc = r + dr[nd], c + dc[nd]
            if newr < 0 or newr >= N or newc < 0 or newc >= N: continue

            if board[newr][newc] == 0:    # 이후 이동한 곳이이 흰색
               check[newr][newc].extend(check[r][c])
               for pos in check[newr][newc]:     # 이동한 말 위치 갱신 
                  pieces[pos-1] = [newr, newc, pieces[pos-1][2]]
               check[r][c] = []

               if check_limit(newr, newc):
                  flag = False
                  break
                  
            elif board[newr][newc] == 1:  # 이후 이동한 곳이 빨간색
               # 해당 말과 그 위의 모든 말의 순서를 바꾸기 
               check[r][c].reverse()
               check[newr][newc].extend(check[r][c])
               for pos in check[newr][newc]:     # 이동한 말 위치 갱신 
                  pieces[pos-1] = [newr, newc, pieces[pos-1][2]]
               check[r][c] = []

               if check_limit(newr, newc):
                  flag = False   
                  break

            else:                         # 이후 이동한 곳이 파란색  
               continue    # 이동하지 않음
   
   if flag == False:
      break  

   turn += 1

if turn > 1000:
   print(-1)
else:
   print(turn)

