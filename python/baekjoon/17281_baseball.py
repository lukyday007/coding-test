# ⚾

# Solution 1 -> 시간 초과 
# base조회할 때 순서 중요! -> 역순으로 
# 홈런이면 base 초기화 
# 최대값 비교할 때, 최댓값도 항상 포함해서 비교 

from itertools import permutations

N = int(input())

# 2 - 9 순열 구하기
arr = [i for i in range(2,10)]
games = [list(map(int, input().split())) for _ in range(N)]
maxV = 0

def play(hit, base):
   score = 0
   for b in range(3, 0, -1):
      if base[b] == 1:
         if b + hit < 4:
            base[b+hit] = 1
         else:
            score += 1
         base[b] = 0
   else:
      base[hit] = 1
   return score

for players in permutations(range(1, 9), 8):
   players = list(players)
   turn = players[:3] + [0] + players[3:]    # 순열 순서 
   idx = score = 0
   for n in range(N):
      out = 0
      base = [0] * 4
      while out < 3:
         hit = games[n][turn[idx]]
         # 아웃
         if hit == 0:
            out += 1
         # 홈런
         elif hit == 4:
            score += 1
            score += base.count(1)
            base = [0] * 4
         # 홈런
         else:
            score += play(hit, base)
         idx = (idx + 1) % 9
   
   maxV = max(maxV, score)
print(maxV)


# Solution 2 -> 메모리 111480kb, 시간 1132ms
from itertools import permutations

n = int(input())  # 이닝 수
result = [list(map(int, input().split())) for _ in range(n)]

max_score = 0

def calculate_score(order):
    idx = 0
    total_score = 0
    for i in range(n):  # 이닝
        b1, b2, b3 = 0, 0, 0  # 베이스 상태
        out = 0
        while out < 3:
            player = order[idx]
            if result[i][player] == 0:  # 아웃
                out += 1
            elif result[i][player] == 1:  # 안타
                total_score += b3
                b1, b2, b3 = 1, b1, b2
            elif result[i][player] == 2:  # 2루타
                total_score += (b2 + b3)
                b1, b2, b3 = 0, 1, b1
            elif result[i][player] == 3:  # 3루타
                total_score += (b1 + b2 + b3)
                b1, b2, b3 = 0, 0, 1
            else:  # 홈런
                total_score += (b1 + b2 + b3 + 1)
                b1, b2, b3 = 0, 0, 0
            idx = (idx + 1) % 9  # 다음 타자
    return total_score

for comb in permutations(range(1, 9), 8):  # 타순 생성
    comb = list(comb)
    order = comb[:3] + [0] + comb[3:]  # 4번 타자 고정
    max_score = max(max_score, calculate_score(order))

print(max_score)

   

      
            
                  

            

            

            







