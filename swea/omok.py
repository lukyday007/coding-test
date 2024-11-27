dr = [1, 1, 0, -1]
dc = [0, 1, 1, 1]

def possible():
    full = "ooooo"
    for r in range(N):
        for c in range(N):
            for d in range(4):
                total = ""
                for i in range(N):
                    nr = r + dr[d] * i
                    nc = c + dc[d] * i
                    if nr < 0 or nr >= N or nc < 0 or nc >= N:
                        break

                    total += board[nr][nc]

                if full in total:
                    return "YES"
                return "NO"

for tc in range(1, int(input()) + 1):
    N = int(input())
    board = [list(input()) for _ in range(N)]

    print(f"#{tc} {possible()}")

full = "ooooo"
total = "ooooo.o"
if full in total:
    print(True)