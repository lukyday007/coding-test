# 순열 생성
# N 개의 요소를 순서대로 나열

# # ver 1 : for loop
# arr = 'ABC'
#
# path = []
# for a in arr:
#     if a in path: continue
#     path.append(a)
#
#     for b in arr:
#         if b in path: continue
#         path.append(b)
#
#         for c in arr:
#             if c in path: continue
#             path.append(c)
#
#             print(path)
#
#             path.pop()
#
#         path.pop()
#
#     path.pop()



# # ver 2 : recursion
# arr = 'ABC'
# N = len(arr)
# path = []
# def perm(k):                # k : 함수 호출
#     if k == N + 1:
#         print(path)
#         return
#     for a in arr:
#         if a in path: continue
#         path.append(a)
#         perm(k + 1)
#         path.pop()
#
# perm(1)

# # ver 3 : check used or not
arr = [i for i in range(1, 5)]
N = len(arr)
path = []
used = [0] * N

for i in range(N):
    used[i] = 1
    path.append(arr[i])
    for j in range(N):
        if arr[i] < arr[j]:
            if used[j] == 1: continue
            used[j] = 1
            path.append(arr[j])
            print(* path)
            path.pop()
            used[j] = 0
    path.pop()
    used[i] = 0
#
# # ver 4 : check used or not with function
#
# def perm(k):
#     if k == N:
#         print(path)
#         return
#
# ver 5 : DP -> 순열을 표현하기 위한 부분집합? memoization
#         bits 안의 정수를 이용, pop() 할 필요가 없다
# def perm(k, bits):
#     if k == N:
#         print(path)
#
#     for i in range(N):
#         if bits & ( 1 << i ): continue
#         path.append()














