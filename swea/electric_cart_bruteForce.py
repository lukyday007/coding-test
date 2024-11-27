# 인접 행렬
# 가중치가 부과된 유향그래프
# 그래프 문제와 비슷

def backtrack(lv):
    global minVal, tmp

    if lv > N:
        return

    if 0 not in bits[1:]:
        for b in range(len(bits) - 1):
            tmp += board[bits[b]][bits[b + 1]]
        tmp += board[bits[-1]][0]
        minVal = min(minVal, tmp)
        tmp = 0
        return

    for i in range(1, N):
        if bits[i] == 0 and lv < N:
            bits[i] = lv
            backtrack(lv + 1)       # 순열을 만드는 길이, depth
            bits[i] = 0

for tc in range(1, int(input()) + 1):
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]
    bits = [0] * N
    path = [0] * N
    minVal = 10000
    tmp = 0
    backtrack(1)

    print(f'#{tc} {minVal}')

