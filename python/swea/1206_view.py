# # solution 1 -> 0.11579s
# for idx in range(10):
#    N = int(input())
#    arr = list(map(int, input().split()))

#    ans = 0
#    for i in range(2, N - 2): # 양쪽 모두 거리 2 공간 확부
#       mx = 0
#       for j in range(i - 2, i + 3):
#          if i == j: continue
#          else: 
#             if arr[j] > mx:
#                mx = arr[j]
      
#       if arr[i] > mx:
#          ans += (arr[i]-mx)
   
#    print(f"#{idx + 1} {ans}")

# solution 2 ->  0.16030s
for idx in range(10):
   N = int(input())
   arr = list(map(int, input().split()))

   ans = 0
   for i in range(2, N - 2): # 양쪽 모두 거리 2 공간 확부
      mx = max(arr[i-2:i] + arr[i+1:i+3])
      
      if arr[i] > mx:
         ans += (arr[i]-mx)
   
   print(f"#{idx + 1} {ans}")