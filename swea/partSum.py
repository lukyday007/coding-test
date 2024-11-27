# partSum

import sys  # 나중에 안됨, 제출할 때는 지워야함
sys.stdin = open('partSum.txt')

T = int(input())
for _ in range(T):
    N, M = map(int, input().split())
    numList = list(map(int, input().split()))

    sumList = []

    for i in range(len(numList)-2):
        sum = 0
        sum = numList[i] + numList[i + 1] + numList[i + 2]
        sumList.append(sum)

    sumList.sort()
    min = sumList[0]
    max = sumList[-1]

    print(f'#{_+1} {max - min}')

