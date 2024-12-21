# 퍼즐 게임 챌린지 
# # ver 1 -> 시간 초과! 
# def solution(diffs, times, limit):
#    N = len(diffs)
#    lv = sum(diffs)//N
#    print(lv)

#    flag = True
#    while flag:
#       total = 0
#       for i in range(N):
#          if diffs[i] > lv:
#             tmp = diffs[i] - lv
#             if i > 1:
#                total += (tmp * sum(times[i-1:i+1]) + times[i])
               
#          else:
#             total += times[i]
      
#       if total > limit:
#          lv += 1
#       else:
#          flag = False

#    return lv

# print(solution([1, 99999, 100000, 99995], [9999, 9001, 9999, 9001], 3456789012))


# ver 2
def calculate(lv, diffs, times):
   N = len(diffs)
   total = 0
   for i in range(N):
      diff = lv - diffs[i]
      time_cur = times[i]
      
      if diff >= 0:        # diff 양수 
         total += time_cur
      else:                # diff 음수 -> 절댓값 처리 
         time_prev = times[i - 1]
         total += ((time_prev + time_cur) * abs(diff) + time_cur)

   return total

def solution(diffs, times, limit):
   sta = 1
   end = max(diffs)
   minV = pow(10, 15)

   while sta <= end:
      lv = (sta + end) // 2
      total = calculate(lv, diffs, times)
      if total > limit:
         sta = lv + 1
      else:
         minV = min(minV, lv)
         end = lv - 1
      
   return minV

print(solution([1, 328, 467, 209, 54], [2, 7, 1, 4, 3], 1723))

