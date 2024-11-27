# 최빈수 구하기
import sys  # 나중에 안됨, 제출할 때는 지워야함
sys.stdin = open('mode.txt')
## 최빈수가 여러 개 일 때에는 가장 큰 점수 출력

def get_mode(tc, lst):

    cntList = [0] * 101
    for i in range(len(lst)):
        cntList[lst[i]] += 1
    maxFre = max(cntList)

    if cntList.count(maxFre) > 1:
        for j in range(100, -1, -1):    # index주의 cntList 에는 101 X
            if cntList[j] == maxFre:

                return f"#{tc} {j}"

    return f"#{tc} {cntList.index(maxFre)}"


for _ in range(int(input())):
    tc = int(input())
    scoreList = list(map(int, input().split()))
    print(get_mode(tc, scoreList))


# ver : 정현조
T = int(input())
for test_case in range(1, T + 1):
    case_num = int(input())
    data = list(map(int, input().split()))
    c = [0] * 101
    for x in data:
        c[x] += 1
    max_val = 0
    max_idx = 1001
    for i in range(0,100):
        if max_val <= c[i]:
            max_val = c[i]
            max_idx = i
    print(f'#{case_num} {max_idx}')
