# 연속합
# 첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다. 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수

'''
반례
2
-1 2
'''
import sys 
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
dp = [0 for _ in range(N)]
dp[0] = arr[0]

# 고려해야 할 예외 케이스 : 모두 음수일 경우 
if max(arr[:]) < 0:
   ans = max(arr[:])
else:
   for i in range(1, N):
      # dp[i-1] + arr[i] : 이전 합계 + 현재 요소의 합
      # 현재 요소가 제일 클 때 
      dp[i] = max(0, dp[i-1] + arr[i], arr[i])
   ans = max(dp[:])
# print(dp)
print(ans)
