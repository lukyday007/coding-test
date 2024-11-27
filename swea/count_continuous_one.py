# 연속한 1의 개수
'''
3
10
0011001110
10
0000100001
10
0111001111
'''
# 첫 줄에 테스트케이스 개수 T,
# 다음 줄부터 테스트케이스별로 첫 줄에 수열의 길이 N,
# 다음 줄에 N개의 0과1로 구성된 수열이 공백없이 제공된다.
# 1 <= T <= 10, 10 <= N <= 1000

# T = int(input())
# for tc in range(1, T + 1):
#     N = int(input())
#     lst = list(map(int, input())) + [0]
#     cnt = 0
#     cntList = []
#     for n in range(N):
#         if lst[n] == 1:
#             cnt += 1
#             if lst[n+1] == 0:
#                 cntList.append(cnt)
#         else:
#             cnt = 0
#     print(f"#{tc} {max(cntList)}")

# # ver 2: user maxSum
T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    lst = list(map(int, input())) + [0]
    maxC = 0
    cnt = 0
    for n in range(N):
        if lst[n] == 1:
            cnt += 1
            if maxC < cnt:
                maxC = cnt
        else:
            cnt = 0
    print(f"#{tc} {maxC}")















