# 제곱수의 합 
'''
첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 100,000)

주어진 자연수 N을 이렇게 제곱수들의 합으로 표현할 때에 그 항의 최소개수

dp[1] 1
dp[2] 1 1
dp[3] 1 1 1
------------
dp[4] 2
dp[5] 2 1
dp[6] 2 1 1 
dp[7] 2 1 1 1 
dp[8] 2 2
------------
dp[9]    3
dp[10]   3 1
dp[11]   3 1 1
dp[12]   3 1 1 1
dp[13]   3 2 
dp[14]   3 2 1 
dp[15]   3 2 1 1  
-------------
16    4
17    4 1
18    4 1 1 
19    4 1 1 1
20    4 2 
21    4 2 1
22    4 2 1 1
23    4 2 1 1 1
24    4 2 2 
'''
# ver 1 
# 111520kb, 304ms
import sys 
input = sys.stdin.readline
N = int(input())
dp = [0 for _ in range(N+1)]

for i in range(1, N + 1):
   if int(i**(1/2)) == i**(1/2):
      dp[i] = 1
   else:
      minV = float("inf")   
      for j in range(1, int(i ** (1/2)) + 1):
         minV = min(dp[i-j**2], minV)
      dp[i] = minV + 1

print(dp[N])


# ver2 -> 시간 더 짧음 참고용 
n = int(input())
dp = [i for i in range(n+1)]

for i in range(1,n+1):
    for j in range(1,i):
        if j*j > i:
            break
        if dp[i-j*j]+1 < dp[i]:
            dp[i] = dp[i-j*j] + 1
            
print(dp[n])