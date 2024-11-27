# di = [0, 1, 0, -1]
# # dj = [1, 0, -1, 0]
# #
# # T = int(input())
# # for tc in range(1, T+1):
# #     N, M = map(int, input().split())
# #     arr = [list(map(int, input().split())) for _ in range(N)]
# #
# #     max_v =  0    # 최대 꽃가루 합계
# #     for i in range(N):      # N X M 크기의 게임판
# #         for j in range(M):
# #             cnt = arr[i][j]     # 터트린 풍선의 꽃가루 수
# #             for k in range(4):      # 주변 풍선의 인엑스 ni, nj
# #                 for l in range(1, arr[i][j] + 1):
# #                     ni = i + di[k] * l
# #                     nj = j + dj[k] * l
# #                     if 0 <= ni < N and 0 <= nj < M:
# #                         cnt += arr[ni][nj]
# #                 if max_v < cnt:
# #                     max_v = cnt
# #
# #     print(f"#{tc} {max_v}")

import sys

sys.stdin = open("balloonPPang1.txt")
dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]

T = int(input())

for tc in range(1, T+1):
    N, M = map(int, input().split())    # N X M 격자판 생성
    arr = [list(map(int, input().split())) for _ in range(N)]
    cntList = []
    for r in range(N):
        for c in range(M):
            # 시작점 좌표 값 저장
            cnt = arr[r][c]
            for k in range(1, arr[r][c] + 1):
                for i in range(4):
                    # 델타 인덱스 * 칸 범위
                    nr = r + dr[i] * k
                    nc = c + dc[i] * k
                    # 범위 제한, 조건에 맞을 시 더하기
                    if 0 <= nr < N and 0 <= nc < M:
                        # print(nr, nc)
                        cnt += arr[nr][nc]
            cntList.append(cnt)
    print(f"#{tc} {max(cntList)}")