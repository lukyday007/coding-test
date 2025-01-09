# 큰 수 만들기 
'''
number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return
'''
# ver 1 : 순열 + 정렬 -> 포기 
def solution(number, k):
   
   answer = ''
   numberList = list(number)
   numberList.sort(reverse=True)
   L = len(numberList) - k
   numberList = numberList[:L]
   print(numberList, k)
   visit = [False for _ in range(L)]
   candidates = []
   
   def permutation(K, string):
      
      if len(string) == L:
         candidates.append(string)
         return 
      
      for i in range(L):
         if not visit[i]:
            visit[i] = True
            permutation(K + 1, string + numberList[i]) 
            visit[i] = False 

   permutation(0, "")
   print(number)
   candidates.sort(reverse=True)
   print(candidates)

   flag1 = False 
   for i in range(len(candidates)-1, -1, -1):
      tmp = 0
      for j in range(len(candidates[i])):
         for k in range(len(number)):
            if candidates[i][j] == number[k]:
               tmp += 1

               if tmp == len(candidates[i]):
                  flag1 = True
               break

         if tmp == len(candidates[i]):
            break
      
   return answer

print(solution("1924", 2))
print(solution("1231234", 3))
print(solution("4177252841", 4))


# ver 2 : 그리디 - 스택 
def solution(number, k):
   number = [int(n) for n in number]
   stack = []
   for n in number:
      while stack and k > 0 and stack[-1] < n:
         stack.pop()
         k -= 1
      
      stack.append(n)
   
   if k > 0:
      stack = stack[:-k]

   return "".join(map(str, stack))

print(solution("1924", 2))
print(solution("1231234", 3))
print(solution("4177252841", 4))