import sys  # 나중에 안됨, 제출할 때는 지워야함
sys.stdin = open('sum.txt')

for tc in range(1, 11):
    N = input()
    arr = [list(map(int, input().split())) for _ in range(100)]
    sumList = []

    # 세로 합
    for r in range(len(arr)):
        sum = 0
        for c in range(len(arr[r])):
            sum += arr[c][r]
        sumList.append(sum)

    # 가로 합
    for r in range(len(arr)):
        sum = 0
        for c in range(len(arr[r])):
            sum += arr[r][c]
        sumList.append(sum)

    # 대각선 합
    up_to_down = 0
    down_to_up = 0
    for r in range(len(arr)):
        for c in range(len(arr[r])):
            if r == c:
                up_to_down += arr[r][c]
            if r + c == 10 - 1:
                down_to_up += arr[r][c]

    sumList.append(up_to_down)
    sumList.append(down_to_up)
    print(f"#{N} {max(sumList)}")




