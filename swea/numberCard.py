# 숫자 카드
# ver1 : 카드 장수가 같을 때는 적힌 숫자가 큰 쪽을 출력 조건 고려 X
# TC = int(input())
#
# for tc in range(TC):
#     digit = [0] * 10
#     N = int(input())
#     ai = list(map(int, input()))
#     for i in range(N):
#         digit[ai[i]] += 1
#     maxCard = max(digit)
#     print(digit)
#     print(f"#{tc + 1} {digit.index(maxCard)} {maxCard}")

# # ver2
# def get_max_numCard(tc, N):
#     maxNum = 0
#     digit = [0] * 10
#     ai = list(map(int, input()))
#
#     # 숫자별 빈도 세기
#     for i in range(N):
#         digit[ai[i]] += 1
#
#     # 숫자 카드 갯수가 똑같을 때, maxFrequency
#     maxFrequency = max(digit)
#     if digit.count(maxFrequency) > 1:
#         for j in range(9, -1, -1):
#             if digit[j] == maxFrequency:
#                 maxNum = j
#                 break
#     else:
#         maxNum = digit.index(maxFrequency)
#
#     return f"#{tc + 1} {maxNum} {maxFrequency}"
#
# for tc in range(int(input())):
#     print(get_max_numCard(tc, int(input())))

# ver3 : 강사님
T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    cards = input()
    # 카운팅 배열을 생성하기 위해 최대값 알기
    # 0 - 9 사이의 값 -> max = 9
    cnt = [0] * (9 + 1)
    for num in cards:
        cnt[int(num)] += 1

    max_idx = 0
    for i in range(1, 9 + 1):
        if cnt[max_idx] < cnt[i]:
            max_idx = i

    print(f"#{tc} {max_idx} {cnt[max_idx]}")

