# 1 <= N <= 100 
# 출력 형식 : 정답을 1000000000으로 나눈 나머지 출력 
# 0 으로 시작하면 안됨 

N = int(input())
dp = [([0] + [0]*10 + [0])for _ in range(N)]
for i in range(2, 11):
   dp[0][i] = 1

if N > 1:
   for i in range(1, N):
      for j in range(1, 11):
         dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]

ans = sum(dp[N-1])
print(ans % 1000000000)