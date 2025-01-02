def solution(progresses, speeds):
   answer = []
   N = len(progresses)
   process = [0 for _ in range(N)]
   stack = []
   for i in range(N):
      if (100 - progresses[i]) % speeds[i] == 0:
         process[i] = (100 - progresses[i]) // speeds[i]
      else:
         process[i] = (100 - progresses[i]) // speeds[i] + 1
      
      if stack and stack[0] > process[i]:
         stack.append(process[i])
      if stack[0] == i + 1:
         stack


   print(process)


   return answer

print(solution([93, 30, 55], [1, 30, 5]))