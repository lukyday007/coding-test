# 풀이 코드 
ipt = list(map(int, input().split()))

sequence = ipt[:-1]
k = ipt[-1]

sta, end = 0, 0
s = 0
maxL = float("inf")
ans = []

while end < len(sequence):
   s += sequence[end]
   while s >= k and sta <= end:
      if s == k:
         val = end - sta + 1
         if val < maxL:
            maxL = val
            ans = [sta, end]
      s -= sequence[sta]
      sta += 1
   end += 1
print(ans)

# 제출 코드 
def solution(sequence, k):
    answer = []
    sta, end = 0, 0
    s = 0
    maxL = float("inf")

    while end < len(sequence):
       s += sequence[end]
       while s >= k and sta <= end:
          if s == k:
             val = end - sta + 1
             if val < maxL:
                maxL = val
                answer = [sta, end]
          s -= sequence[sta]
          sta += 1
       end += 1
    
    return answer
