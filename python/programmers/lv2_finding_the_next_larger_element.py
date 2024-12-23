# 뒤에 있는 큰 수 찾기 
'''
 뒷 큰수: 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이에 있는 수
 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열 return 
 뒷 큰수가 없는 원소는 -1
 
'''
# 접근 1: 투 포인터 -> 시간 복잡도 O(N^2) => 시간 초과! 
def solution(numbers):
   answer = [-1] * len(numbers)
   sta, end = 0, 0
   while end < len(numbers):
      print(f"here0 -> {sta}, {end}")
      end += 1
      while sta < end and end < len(numbers):
         print(f"here1 -> {sta}, {end}")
         if numbers[sta] < numbers[end]:
            for i in range(sta, end):
               answer[i] = numbers[end]
               print(answer)
            break
         end += 1
         print(f"here3 -> {sta}, {end}")
      sta += 1
   
   return answer

print(solution([9, 1, 5, 3, 6, 2]))


# 접근 2 : 스택 -> 힌트 : '자신보다 크면서 가장 가까이에 있는' => 통과  
def solution(numbers):
   answer = [-1] * len(numbers)
   st = []
   for i in range(len(numbers)):
      while st and numbers[st[-1]] < numbers[i]:
         answer[st[-1]] = numbers[i]
         st.pop()
      st.append(i)
   return answer

print(solution([9, 1, 5, 3, 6, 2]))         




