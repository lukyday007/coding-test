import sys
sys.stdin = open('catchFlee.txt')

T = int(input())
for tc in range(1, T+1):
    N, M = list(map(int, input().split()))
    arr = [list(map(int, input().split())) for _ in range(N)]
    sumList = []

    for r in range(0, N - M + 1):
        for c in range(0, N - M + 1):
            sum = 0
            for row in range(r, r + M):
                for col in range(c, c + M):
                    # print(f"row: {row}, col: {col}, arr[row][col]: {arr[row][col]}")
                    sum += arr[row][col]
                sumList.append(sum)

    print(f"#{tc} {max(sumList)}")

