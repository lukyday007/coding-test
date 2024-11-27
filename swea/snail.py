dr = [ 0, 1, 0, -1] # 우하좌상
dc = [ 1, 0, -1, 0]
N = 6
arr = [[0] * N for _ in range(N)]

cnt = 0
num = 1
r = 0
c = 0
while N > 0:
    if N == N:
        arr[0][0] = num
        nr = r
        nc = c
        for i in range(3):
            nr += dr[i]
            nc += dc[i]
            for j in range(N - 1):  # N = 6 일 때 5번 반복
                if j == 0:
                    pass
                else:
                    nr += dr[i]
                    nc += dc[i]
                if 0 <= nr < N and 0 <= nc < N:
                    num += 1
                    arr[nr][nc] = num


    num += 1
    #
    # else:
    #     for i in range(2):
    #         for j in range(N-1):
    #             nr = r + dr[i]
    #             nc = c + dc[i]
    #             print(nr, nc)
    #             if 0 <= nr < N and 0 <= nc < N:
    #                 arr[nr][nc] = num
    #             num += 1

    N -= 1







    N -= 1



# 사다리
# 밑에서 위로 올라가는 방법 찾기
# 도착점 = 시작점



