# 좋다 

'''
N개의 수 중에서 어떤 수가 
다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.

N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.

수의 위치가 다르면 값이 같아도 다른 수이다.

첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 
두 번째 줄에는 i번째 수를 나타내는 Ai가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수)

좋은 수의 개수를 첫 번째 줄에 출력한다.

10
1 2 3 4 5 6 7 8 9 10 => 8

3,4,5,6,7,8,9,10은 좋다.
'''

# ver 1 -> 당연하겠지만 시간초과 
import sys 
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
ans = 0

arr.sort()  # 정렬 

def is_good(num, arr, idx):
   for i in range(N - 1):
      if i == idx: continue 

      for j in range(i + 1, N):
         if j == idx: continue 

         if num == arr[i] + arr[j]:
            return 1
   return 0

for idx in range(len(arr)):
   res = is_good(arr[idx], arr, idx)
   ans += res 

print(ans)


# ver 2: 투포인터 
# 110860kb, 144ms
import sys 
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
ans = 0

arr.sort()  # 정렬 

for idx in range(len(arr)):
   tmp = arr[:idx] + arr[idx+1:]
   sta, end = 0, len(tmp) - 1
   while sta < end:
      sum = tmp[sta] + tmp[end]
      if sum == arr[idx]:
         ans += 1
         break

      if sum < arr[idx]:
         sta += 1
      else: 
         end -= 1
print(ans)

         
      

