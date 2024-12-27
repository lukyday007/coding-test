# 산타 춘배의 선물 나눠주기 
# N 개의 선물을 N/2마리에게 2개 씩 나누어 줌 -> N은 짝수 
# 가격은 0 이상 3 이하의 정수
# 만족도는, 받은 선물 2개의 가격을 XOR한 값
# 선물 2개의 가격이 각각 1, 2라면 만족도는 1 XOR 2=3이고, 
# 선물 2개의 가격이 각각 3, 3라면 만족도는 3 XOR 3=0이다.
# 0101 + 0110 = 0011
# 2 ≤ N ≤ 200000, N 짝수 
# 얻을 수 있는 만족도의 최댓값을 출력

# ver 1 : 순열 -> 시간 초과! 날 줄 알았음 ㅋㅋㅋ 
import sys
sys.setrecursionlimit(10**6)

def get_xor_result(a, b):
   result = ""
   for i in range(2):   
      # xor 비교 
      if a[i] == b[i]:
         result += "0"
      else: 
         result += "1"
   
   # 10진법으로 변환 
   return int("0b" + result, 2) 

def get_maxV(group):
   global maxV

   for lst in group:
      new = [(lst[i], lst[i + 1]) for i in range(0, N, 2)]
      tmp = 0
      for a, b in new:
         tmp += get_xor_result(a, b)
      maxV = max(maxV, tmp)

def permutation(arr):
   global group

   if len(arr) == N:
      group.append(arr[:])
      return 

   for i in range(N):
      if not visit[i]:
         visit[i] = 1
         permutation(arr + [presents[i]])
         visit[i] = 0
   
N = int(input())
presents = list(map(int, input().split()))
visit = [0] * N
group = []

for p in range(len(presents)):
   presents[p] = bin(presents[p])[2:]

for p in range(len(presents)):
   if len(presents[p]) == 1:
      presents[p] = '0'+presents[p]

permutation([])
   
# N 일 때 나누어 줄 수 있는 선물의 조합 중 최댓값 구하기 
maxV = 0 
get_maxV(group)
print(maxV)


# ver 2 : 그리디 
'''
0 1 2 3으로만 숫자가 한정되고

같은 수 xor하면 0이며
0-3 1-2가 가장 크며 나머진 그 다음이다
'''
def get_xor_val(a, b):
   # 2 진법 변환 
   a = bin(a)
   b = bin(b)
   a = a[2:]
   b = b[2:]

   if len(a) == 1:
      a = "0" + a
   if len(b) == 1:
      b = "0" + b

   result = ""
   for i in range(2):   
      # xor 비교 
      if a[i] == b[i]:
         result += "0"
      else: 
         result += "1"
   
   # 10진법으로 변환 
   return int("0b" + result, 2) 


def calculate(a, b):
   global total

   gap = get_xor_val(a, b)
   if cnt[a] > 0 and cnt[b] > 0:
      val = min(cnt[a], cnt[b])
      total += val * gap
      cnt[a] -= val
      cnt[b] -= val


N = int(input())
lst = list(map(int, input().split()))
cnt = [0 for _ in range(4)]      # 0, 1, 2, 3
total = 0

# 0, 3 / 1, 2 => 3
# 0, 2 / 1, 3 => 2
# 0, 1 / 2, 3 => 1 
# 같은 숫자 끼리는 0

for l in lst:
   cnt[l] += 1

calculate(0, 3)
calculate(1, 2)
calculate(0, 2)
calculate(1, 3)
calculate(0, 1)
calculate(2, 3)

print(total)
