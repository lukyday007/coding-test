# #연속한 1의 개수를 세는 문제
# K = 3
# N = 6
# arr = [0, 1, 0, 1, 1, 1]
# # arr = [0, 1, 0, 1, 1, 1, 0]
# # 이럴 때는 if i == N - 1 and cnt == K 조건이 필요 X
# ans = 0
# cnt = 0
# for i in range(N):
#     # if arr[i]:  # 1이면 증가 but 마지막이 1로 끝나면 끝가지 가지 못함
#     #     cnt += 1
#     # elif arr[i] == 0 or i == N - 1:
#     if arr[i] == 0:
#         if cnt == K:
#             ans += 1
#         cnt = 0
#     else:
#         cnt += 1
#         if i == N - 1 and cnt == K:  # 맨 끝이 1일 때도 체크하기!
#             ans += 1
# print(ans)

# # 어디에 단어가...
# T = int(input())
# for tc in range(1, T+1):
#     N, K = map(int, input().split())
#     arr = [list(map(int, input().split())) +[0] for _ in range(N)] + [[0] * (N + 1)]
#     N += 1
#     ans = 0
#     # 가로 순회
#     for i in range(N):
#         cnt = 0     # i 행에서 연속한 1의 개수
#         for j in range(N):
#             if arr[i][j]:
#                 cnt += 1
#             else:   # arr[i][j] == 0이면 초기화
#                 if cnt == K:
#                     ans += 1
#                 cnt = 0
#     # 세로 순회
#     for i in range(N):
#         cnt = 0     # i 행에서 연속한 1의 개수
#         for j in range(N):
#             if arr[j][i]:
#                 cnt += 1
#             else:   # arr[j][i] == 0이면 초기화
#                 if cnt == K:
#                     ans += 1
#                 cnt = 0
#     print(f"#{tc} {ans}")

import sys
sys.stdin = open("whereCanTheWordInsert.txt")

T = int(input())
for tc in range(1, T+1):
    # N x N, K 단어 길이
    N, K = map(int, input().split())
    arr = [list(map(int, input().split())) +[0] for _ in range(N)] + [[0] * (N + 1)]

    possible = 0
    cntR = 0
    cntC = 0
    for r in range(N + 1):
        for c in range(N + 1):
            if arr[r][c] == 1:
                cntR += 1
                if arr[r][c + 1] == 0 and cntR == K:
                    possible += 1
                # print(f"cntR : {cntR}, possible : {possible}")
            else:
                cntR = 0
            if arr[c][r] == 1:
                cntC += 1
                if arr[c + 1][r] == 0 and cntC == K:
                    possible += 1
                # print(f"cntC : {cntC}, possible : {possible}")

            else:
                cntC = 0
    print(f"#{tc} {possible}")















