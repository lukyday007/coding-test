# # min_max
# import sys
#
# def get_diff_Mm(t, lst):
#     M = 0
#     m = 1000000
#     for i in range(len(lst)):
#         if M < lst[i]:
#             M = lst[i]
#         if m > lst[i]:
#             m = lst[i]
#     return f"#{t + 1} {M-m}"
#
#
# T = int(sys.stdin.readline())
# for t in range(T):
#     N = int(sys.stdin.readline())
#
#     numList = list(map(int, sys.stdin.readline().split()))
#     print(get_diff_Mm(t, numList))


