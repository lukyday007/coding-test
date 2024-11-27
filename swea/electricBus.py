# 버스는 0번에서 출발해 종점인 N번 정류장까지 이동하고,
# 한번 충전으로 최대한 이동할 수 있는 정류장 수 K가 정해져 있다.
# 충전기가 설치된 M개의 정류장 번호가 주어질 때
import sys  # 나중에 안됨, 제출할 때는 지워야함
sys.stdin = open('electricBus.txt')

# T = int(input())
# for t in range(T):
#     K, N, M = map(int, input().split())
#     mList = list(map(int, input().split()))
#     electric = K
#     move = 0
#     cnt = 0
#     for n in range(N + 1):      # 10
#         move += 1
#         electric -= 1
#         print(f"이동한 거리: {move}, 전기: {electric}")
#         for m in range(len(mList)-1):     # 1 3 5 7 9
#             if m == 4:
#                 if not N - move <= electric:
#                     cnt += 1
#                     electric += K
#                     print(f"\t충전한 횟수: {cnt}, 전기: {electric}")
#             if not N - move <= electric:
#                 cnt += 1
#                 electric += K
#                 print(f"\t충전한 횟수: {cnt}, 전기: {electric}")
#     print("=-=-=-=-=-==-=-=-=-=-=-=-=-")



# for i in range(cur+move, cur-1, -1):
#     print(i, end = " ")

# def possible(K, lst):
#     for charge in range(cur + K, cur-2, -1):
#         if charge in lst:
#             return charge
#     return 0
#
#
# # T = 테스트 횟수
# T = int(input())
# for tc in range(1, T + 1):
#     # K = 한 번에 충전할 수 있는 최대 연료량
#     # N = 이동 거리
#     # M = 충전소 개수
#     # chargeStations = 충전소가 있는 리스트
#
#     K, N, M = map(int, input().split())
#     chargeStations = list(map(int, input().split()))
#
#     cur = 0
#     cnt = 0
#     next = 0
#     while cur < N:
#
#         next = cur + K
#         result = possible(K, chargeStations)    # 여기 왜 계속 3을 리턴받지?
#
#         if result == 0:
#             cnt = 0
#             break
#
#         if next >= N:
#             break
#
#         cur = result
#         cnt += 1
#     print(f"#{tc} {cnt}")

# # ver 3: made by myself
# def possible(K, lst):
#     for charge in range(cur + K, cur, -1):
#         if charge in lst:
#             return charge
#     return 0
#
# T = int(input())
# for tc in range(1, T + 1):
#     K, N, M = map(int, input().split())
#     chargeStations = list(map(int, input().split()))
#
#     cur = 0
#     cnt = 0
#     mext = 0
#     while cur + K < N:
#         result = possible(K, chargeStations)
#
#         if result == 0:
#             cnt = 0
#             break
#
#         cur = result
#         cnt += 1
#     print(f"#{tc} {cnt}")


# Final version: Solution
K, N, M = map(int, input().split())
arr = list(map(int, input().split()))
stop = [0] * (N + 1)
for num in arr:
    stop[num] = 1

cur = 0
ans = 0

while cur + K < N:
    for i in range(cur+K, cur, -1):
        if stop[i] == 1:
            ans += 1
            cur = i
            break
    # break가 걸려서 충전이 끝나지 않으면
    else:
        ans = 0
        break





