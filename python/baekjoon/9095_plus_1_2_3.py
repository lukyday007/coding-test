# 1, 2, 3 더하기
# 108384kb, 92ms
'''
d[1]  1
d[2]  1 + 1 
      2
d[3]  1 + 1 + 1 | 2 + 1 
      1 + 2 
      3
d[4]  1 + 1 + 1 + 1 | 2 + 1 + 1 | 1 + 2 + 1 | 3 + 1  
      2 + 2 | 1 + 1 + 2
      1 + 3 
d[5]  1 + 1 + 1 + 1 + 1 | 2 + 1 + 1 + 1 | 1 + 2 + 1 + 1 | 3 + 1 + 1 | 2 + 2 + 1 | 1 + 3 + 1
      1 + 1 + 1 + 2 | 2 + 1 + 2 | 1 + 2 + 2 | 3 + 2
      1 + 1 + 3 | 2 + 3 

N > 3 일 때
D[N] = D[N-3] + D[N-2] + D[N-1]
'''

# N > 3 일 때부터 점화식 적용 
import sys
input = sys.stdin.readline

dp = [0 for _ in range(20)]
dp[1] = 1
dp[2] = 2
dp[3] = 4

for _ in range(int(input())):
   N = int(input())

   if N > 3:    
      for i in range(4, N + 1):
         dp[i] = dp[i-3] + dp[i-2] + dp[i-1]

   print(dp[N])

