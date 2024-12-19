# 오르막 수 

# ver 1 - 111416kb, 112ms 
N = int(input())
dp = [[0] * 11 for _ in range(N + 1)]

for i in range(10):
   dp[1][i] = 1

if N > 1:
   for i in range(2, N+1):
      for j in range(10):
         dp[i][j] = sum(dp[i-1][j:]) 

print(sum(dp[N])%10007)


# ver 2 - 109544kb, 96ms 
N = int(input())
dp = [1] * 10

for _ in range(N-1):
   for i in range(1, 10):
      dp[i] += dp[i-1]

print(sum(dp) % 10007)
