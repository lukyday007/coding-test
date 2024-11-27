# 지도의 크기 N , 폭탄의 수 M
for tc in range(1, int(input())+1):
    N, M = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]
    dr = [1, -1, 0, 0]
    dc = [0, 0, 1, -1]
    damage = 0
    for _ in range(M):
        x, y, s = map(int, input().split())
        damage += board[x][y]
        for i in range(4):
            nr = x
            nc = y
            for j in range(1, s+1):
                nr = x + dr[i] * j
                nc = y + dc[i] * j
                if 0 <= nr < N and 0 <= nc < N:
                    damage += board[nr][nc]
                    board[nr][nc] = 0


    print(f"#{tc} {damage}")






