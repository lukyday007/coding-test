# # ver 1: 반복문으로
# T = int(input())
# for tc in range(1, T+1):
#     # 노드 개수, 리프 노드 개수, 값 출력 노드 번호
#     N, M, L = map(int, input().split())
#     H = [0] * (N+1)     # [0, 0, 0, 3, 1, 2]
#     for _ in range(M):
#         a, b = map(int, input().split())
#         H[a] = b
#
#     for i in range(N-M, 0, -1):
#         # 마지막 노드가 범위를 벗어나는지 체크
#         if i*2 + 1 > N:
#             H[i] = H[i*2]
#         else:
#             H[i] = H[i*2] + H[i*2 + 1]
#
#     print(f'#{tc} {H[L]}')

# ver 2:  백트래킹으로
N, M, L = map(int, input().split())
H = [0] * (N+1)     # [0, 0, 0, 3, 1, 2]
for _ in range(M):
    a, b = map(int, input().split())
    H[a] = b

def binary_sum(idx):
    if idx > N:
        return
    # 범위 벗어나는지 체크
    if idx*2 + 1 > N:
        return H[2*idx]

    binary_sum(idx*2)
    binary_sum(idx*2+1)

    # 단말노드 확인
    if H[idx]:
        return
    H[idx] = H[2*idx] + H[2*idx + 1]

binary_sum(1)
print(H[L])
