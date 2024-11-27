# N 개의 정수가 주어지면 가장 큰 수, 2번째 큰 수, 2번째 작은 수 식으로 번갈아 정렬
# 10 1 9 2 8 3 7 4 6 5

import sys  # 나중에 안됨, 제출할 때는 지워야함
sys.stdin = open('specific_sort.txt')

# T = int(input())
# for tc in range(1, T+1):
#     N = int(input())
#     lst = list(map(int, input().split()))
#     lst.sort()
#     arr = [0]*N
#
#     a, b = lst[:N//2], lst[N//2:]
#     b = b[::-1]
#
#     for i in range(0, N//2):
#         arr[2*i+1] = a[i]
#         arr[2*i] = b[i]
#     print(f"#{tc}", end=" ")
#     for a in range(len(arr)):
#         if a > 9:
#             break
#         print(arr[a], end=" ")
#     print()

# ver 2
T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = list(map(int, input().split()))
    for r in range(0, N-1):
        min_idx = r
        max_idx = r
        # print(f"r : {r}")
        for c in range(r+1, N):
            if arr[min_idx] > arr[c]:
                min_idx = c
            if arr[max_idx] < arr[c]:
                max_idx = c
        if r % 2 == 0:
            arr[r], arr[max_idx] = arr[max_idx], arr[r]
        if r % 2 != 0:
            arr[r], arr[min_idx] = arr[min_idx], arr[r]

    print(f"#{tc}", end=" ")
    for a in range(10):
        print(arr[a], end=" ")
    print()


# # 최소/최대값의 인덱스 찾기
# arr = [64, 25, 10, 22 ,11]
# N = len(arr)
#
# min_idx = 0                     # 첫 번째 원소를 최소값으로 가정하고 인덱스를 저장
# for i in range(1, N):           # 두 번째 원부터 하나씩 가져와서 비교
#     if arr[min_idx] > arr[i]:   # 지금까지 구한 최소값 보다 작은 값인지 비교
#         min_idx = i             # 최소값의 위치를 갱신
# print(f'arr[{min_idx}] == {arr[min_idx]}')
#
#
# # ==========================================
# # 선택 정렬
# arr = [64, 25, 10, 22 ,11]
# N = len(arr)
#
# for i in range(0, N - 2 + 1):
#     min_idx = i
#     for j in range(i + 1, N):
#         if arr[min_idx] > arr[j]:
#             min_idx = j
#     arr[i], arr[min_idx] = arr[min_idx], arr[i]












