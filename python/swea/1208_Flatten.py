# solution 1 -> 131 ms
for num in range(1, 11):
   N = int(input())
   arr = list(map(int, input().split()))

   idx = 0
   while idx < N:
      mx_idx = arr.index(max(arr))
      mn_idx = arr.index(min(arr))

      arr[mx_idx] -= 1
      arr[mn_idx] += 1

      idx += 1

   ans = max(arr) - min(arr)

   print(f"#{num} {ans}")


# solution 2 -> 152 ms
for num in range(1, 11):
   N = int(input())
   arr = list(map(int, input().split()))
   ans = 100   # 최대 높이 

   for _ in range(N):
      arr.sort()
      arr[0] += 1
      arr[-1] -= 1

      if ans > max(arr) - min(arr):
         ans = max(arr) - min(arr)

   print(f"#{num} {ans}")





