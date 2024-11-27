# 점점 커지는 당근의 개수

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    lst = list(map(int, input().split())) + [0]
    cnt = 0
    cntList = []

    for i in range(len(lst) - 1):
        tmp = lst[i]

        if lst[i] < lst[i + 1]:
            cnt += 1
            # print(lst[i], lst[i+1])
        else:
            cnt = 0

    if cnt == 0:
        cnt += 1

    print(cnt)


