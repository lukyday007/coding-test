# import sys
# sys.stdin = open("cypher_code.txt")
#
# for tc in range(1, int(input())+1):
#     N, M = map(int, input().split())
#     l = 7
#     line = [input() for _ in range(N)]
#     code = ['0001101', '0011001', '0010011', '0111101', '0100011', '0110001', '0101111', '0111011', '0110111',
#             '0001011']
#
#     def first_one():
#         for i in range(len(line)):
#             for j in range(len(line[i]) - 1, -1, -1):
#                 if line[i][j] == '1':
#                     return i, j
#         return 1000
#
#     if first_one() != 1000:
#         r, c = first_one()
#         idx = c
#         result = ""
#         for i in range(idx, -1, -7):
#             if i - 7 > 0:
#                 tmp = line[r][i-6 : i+1]
#                 if tmp in code:
#                     result += str(code.index(tmp))
#
#         result = list(result)
#         result.reverse()
#         odd = 0
#         even = 0
#         for k in range(len(result)):
#             if k % 2 == 0:
#                 odd += int(result[k])
#             else:
#                 even += int(result[k])
#
#         if (3 * odd + even) % 10 == 0:
#             print(f"#{tc} {odd + even}")
#         else:
#             print(f"#{tc} 0")



# ver 2: using rstrip('0')











