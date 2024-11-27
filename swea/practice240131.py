# # 지그재그 탐색
# array = [[1,2,3], [4,5,6], [7,8,9], [10,11,12]]
# n = len(array)
# m = len(array[0])
#
# for i in range(n):
#     for j in range(m):
#         print(array[i][j] + (m-1-2*j)*(i%2), end=" ")
#     print()

## 델타를 이용한 2차 배열 탐색
## Define a 2D grid
# grid = [
#     [1, 2, 3, 4],
#     [5, 6, 7, 8],
#     [9, 10, 11, 12],
#     [13, 14, 15, 16]
# ]
#
# # Starting point
# i, j = 1, 2  # For example, grid[1][2] is 7 in the grid
#
# # Direction arrays
# di = [0, 1, 0, -1]
# dj = [1, 0, -1, 0]
#
# # Iterate over the four directions
# for k in range(4):
#     ni = i + di[k]
#     nj = j + dj[k]
#
#     # Check if the new indices are within the grid bounds
#     if 0 <= ni < len(grid) and 0 <= nj < len(grid[0]):
#         print(f"Direction {k}: New position: ({ni}, {nj}), Value: {grid[ni][nj]}")
#     else:
#         print(f"Direction {k}: New position: ({ni}, {nj}) is out of bounds")
#
# # i : 행의 좌표, len(arr)
# # j : 열의 좌표, len(arr[0])
# arr = [[1, 2, 3], [4, 5, 6], [7, 8, 9]] # 3x3 행렬
# for i in range(3):
#     for j in range(3):
#         if i < j:
#             arr[i][j], arr[j][i] = arr[j][i], arr[i][j]
#         print(arr[i][j], end=" ")
#     print()

# # Practice 1 - 2
# # Create and fill the 2D array
# array_2d = [[0 for _ in range(5)] for _ in range(5)]
# num = 1
# for i in range(5):
#     for j in range(5):
#         array_2d[i][j] = num
#         num += 1
#
# # Direction arrays
# di = [0, 1, 0, -1]
# dj = [1, 0, -1, 0]
#
# # Choose an element (i, j)
# i, j = 2, 2  # Example: element in the middle of the array
#
# # Calculate and print absolute differences
# for k in range(4):
#     ni = i + di[k]
#     nj = j + dj[k]
#
#     # Check if the neighbor indices are within the grid
#     if 0 <= ni < 5 and 0 <= nj < 5:
#         abs_diff = abs(array_2d[i][j] - array_2d[ni][nj])
#         print(f"Absolute difference with neighbor at ({ni}, {nj}): {abs_diff}")
#     else:
#         print(f"Neighbor at ({ni}, {nj}) is out of bounds")

# # 부분 집합 생성하기
# def print_subset(bit_array):
#     print(' '.join(map(str, bit_array)))
#
# bit = [0, 0, 0, 0]
# for i in range(2):
#     bit[0] = i
#     for j in range(2):
#         bit[1] = j
#         for k in range(2):
#             bit[2] = k
#             for l in range(2):
#                 bit[3] = l
#                 print_subset(bit)

# # # Simple Version
# arr = [1,2,3,4]
# n = len(arr)
# print(n)
# print(1<<n)
# print(n>>1)

# for i in range(1<<n):
#     # print(i)
#     for j in range(n):
#         if i & (1<<j):
#             print(arr[j], end=", ")
#     print()



# # practice : 부분집합의 합 문제 구현하기
'''
10
-7 -5 2 3 8 -2 4 6 9
'''
# N = int(input())
# arr = list(map(int, input().split()))
#
# for i in range(1 << N):
#     s = 0
#     for j in range(N):
#         if i & ( 1 << j ):
#             s += arr[j]
#             print(arr[j], end=" ")
#     print(s)

# # 5x5 격자 만들기
# N = 5
# arr = [[0] * N for _ in range(N)]
#
# for line in arr:
#     print(*line)    # * = unpacking

# # 5x5 격자 만들기 with 숫자
N = 5
# arr = [[0] * N for _ in range(N)]
# num = 1
#
# for r in range(N):
#     for c in range(N):
#         arr[r][c] = num
#         num += 1
#
# for line in arr:
#     print(*line)

# # 5x5 격자 만들기 with zigzag
# # 짝수 행 경우 홀수 행 경우 다르게
# for r in range(N):
#     if r % 2 == 0:
#         for c in range(N):
#
#             arr[r][c] = num
#             num += 1
#     else:
#         for c in range(N-1, -1, -1):
#             arr[r][c] = num
#             num += 1
#
# for line in arr:
#     print(*line)

# # 대각선 합 구하기
# arr2 = [[0] * N for _ in range(N)]
#
# for r in range(N):
#     for c in range(N):
#         if r == c:
#             arr2[r][c] = 1
#         if abs(r + c) == N - 1:
#             arr2[r][c] = 2
#
# for line in arr2:
#     print(*line)

# # 삼각형? 계산
# for r in range(N):
#     for c in range(N):
#         arr[r][c] = 1

# # 테두리 부분 만 접근 or 가장자리를 뺀 내부 접근 사각형
# # 1 ~ n-2
# # 1 ~ n-2
# arr3 = [[0] * N for _ in range(N)]
#
# for r in range(1, N - 2 + 1):
#     for c in range(1, N - 2 + 1):
#         arr3[r][c] = 1
#
# for line in arr3:
#     print(*line)


# N = 5
# array = [[0] * N for _ in range(N)]
# num = 1
#
# di = [0, 1, 0, -1]
# dj = [1, 0, -1, 0]
#
# for r in range(N):
#     for c in range(N):
#         array[r][c] = num
#         num += 1
#
# x, y = 2, 2
# sum = 0
#
# for r in range(N):
#     for c in range(N):
#         for idx in range(len(di)):
#             nr = x + di[idx]
#             nc = y + dj[idx]
#             print(nr, nc)
# sum += array[x][y]
#
# print(sum)



#
# for line in array:
#     print(*line)



array_2d = [[0 for _ in range(5)] for _ in range(5)]
num = 1
for i in range(5):
    for j in range(5):
        array_2d[i][j] = num
        num += 1

# Choose an element (i, j)
i, j = 2, 2  # Example: element in the middle of the array

for line in array_2d:
    print(*line)
print()

# Direction arrays
di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]
# Calculate and print absolute differences
for k in range(4): # 0 1 2 3
    ni = i + di[k] # i = 2
    nj = j + dj[k] # j = 2
    print(array_2d[ni][nj], end=" ")

    # # Check if the neighbor indices are within the grid
    # if 0 <= ni < 5 and 0 <= nj < 5:
    #     abs_diff = abs(array_2d[i][j] - array_2d[ni][nj])
    #     print(f"Absolute difference with neighbor at ({ni}, {nj}): {abs_diff}")
    # else:
    #     print(f"Neighbor at ({ni}, {nj}) is out of bounds")












