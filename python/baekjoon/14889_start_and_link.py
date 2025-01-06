# 스타트와 링크 

'''
첫째 줄에 N(4 ≤ N ≤ 20, N은 짝수)
둘째 줄부터 N개의 줄에 S
각 줄은 N개의 수, i번 줄의 j번째 수는 Sij
Sii는 항상 0이고, 나머지 Sij는 1보다 크거나 같고, 100보다 작거나 같은

첫째 줄에 스타트 팀과 링크 팀의 능력치의 차이의 최솟값
2개씩 조합 
'''

import sys
input = sys.stdin.readline
N = int(input())
visit = [False for _ in range(N)]
board = [list(map(int, input().split())) for _ in range(N)]
minV = 200

def get_sum(tmp):
   total = 0

   for i in range(len(tmp) - 1):
      for j in range(i+1, len(tmp)):
         total += board[tmp[i]][tmp[j]]
         total += board[tmp[j]][tmp[i]]
   return total 

def backtracking(K, lst):
   global minV

   if len(lst) == N//2:
      arr = [i for i in range(N) if not visit[i]]  
      minV = min(abs(get_sum(lst) - get_sum(arr)), minV)
      return 
      
   for i in range(K):
      if not visit[i]:
         visit[i] = True
         backtracking(i + 1, lst + [i])
         visit[i] = False 

backtracking(N, [])
print(minV)















