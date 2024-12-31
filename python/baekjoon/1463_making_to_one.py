# 1로 만들기 
'''
1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
2. X가 2로 나누어 떨어지면, 2로 나눈다.
3. 1을 뺀다.
'''
import sys
input = sys.stdin.readline

N = int(input())
dp = [0 for _ in range(N + 1)]
dp[1] = 0

for i in range(2, N + 1):
   dp[i] = dp[i-1] + 1
   # print(f"[{i}] -1 : dp - {dp}")
   if i % 3 == 0:
      dp[i] = min(dp[i//3] + 1, dp[i])
      # print(f"[{i}] /3 : dp - {dp}")
   if i % 2 == 0:
      dp[i] = min(dp[i//2] + 1, dp[i])
      # print(f"[{i}] /2 : dp - {dp}")

print(dp[N])

