def solution(progresses, speeds):
   answer = []
   # 작업 시간 처리 
   days = [(100 - p) // s + (1 if (100 - p) % s > 0 else 0) for p, s in zip(progresses, speeds)]
   
   stack = [days[0]]
   for i in range(1, len(days)):
      print(f"stack 전 : {stack}")
      if stack and stack[0] < days[i]:
         answer.append(len(stack))
         print(f"answer: {answer}")
         stack = []
      stack.append(days[i])
      print(f"stack 후 : {stack}")
      print()
   
   if stack:   # 스택이 남아있는 작업 처리 
      answer.append(len(stack))
      
   return answer

# print(solution([93, 30, 55], [1, 30, 5]))
print(solution([95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1]))