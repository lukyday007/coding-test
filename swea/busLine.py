# # ver 1
# T = int(input())
# for tc in range(1, T+1):
#     N = int(input())
#     counts = [0] * 5001  #  0 - 5000 번 정류장
#     # N개의 노선을 정류장에 표시
#     for i in range(N):
#         A, B = map(int, input().split())
#         for j in range(A, B + 1):   # 1 <= A <= B < 5000
#             counts[j] += 1
#
#         P = int(input())
#         busStop = [int(input()) for _ in range(P)]
#         print(f"#{tc}", end = " ")
#         for i in busStop:   # 출력할 정류장 번호
#             print(counts[i], end=" ")   # 테스트 케이스 가로 이어서 출력 주의
#         print()

# # ver2 by myself

'''
2
2
1 3
2 5
5
1
2
3
4
5
2
1 4
2 6
5
1
2
3
4
5
'''
T = int(input())
for tc in range(1, T+1):
    N = int(input())
    line = [0] * 5001   # 1 ≤ Ai ≤ Bi ≤ 5,000
    # 버스 출발 도착 입력
    for j in range(N):
        a, b = map(int, input().split())
        for i in range(a, b+1):
            line[i] += 1
    # 정류장 수 입력, 리스트에 저장
    P = int(input())
    busStop = [int(input()) for _ in range(P)]
    print(f"#{tc}", end=" ")
    # busStop에 저장된 버스 번호를 idx로 line배열의 값을 출력
    for bs in busStop:
        print(f"{line[bs]}", end = " ")













