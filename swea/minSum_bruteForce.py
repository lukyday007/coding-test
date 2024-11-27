def backtrack(r, c, k, limit):
    global minVal, tmp

    if k + 1 < limit and tmp > minVal:
        return

    if k + 1 == limit:
        if r + 1 != N or c + 1 != N:
            return
        elif r + 1 == N and c + 1 == N:
            if minVal > tmp:
                minVal = tmp
            return

    for i in range(2):
        nr = r + dr[i]
        nc = c + dc[i]

        if nr < 0 or nc < 0 or nr >= N or nc >= N: continue
        tmp += board[nr][nc]
        backtrack(nr, nc, k + 1, limit)
        tmp -= board[nr][nc]

dr = [1, 0]
dc = [0, 1]
for tc in range(1, int(input()) + 1):
    minVal = 1000
    N = int(input())
    limit = 2 * N - 1
    board = [list(map(int, input().split())) for _ in range(N)]
    tmp = board[0][0]
    backtrack(0, 0, 0, limit)
    print(f'#{tc} {minVal}')
