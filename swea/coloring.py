import sys  # 나중에 안됨, 제출할 때는 지워야함
sys.stdin = open('coloring.txt')
## 더하기~!!@!@!@!@!@!@!@!@!@!@!@!@!@@! 1 + 2 = 3

# # ver 1
T = int(input())
for tc in range(1, T + 1):
    paper = [[0]*10 for i in range(10)]
    count2 = 0

    N = int(input())
    paints = []
    for n in range(N):
        paint = list(map(int, input().split()))
        paints.append(paint)

    for i in range(len(paints)):
        color = paints[i][-1]    # 2, 4/ 3, 6
        for r in range(paints[i][0], paints[i][2] + 1):
            for c in range(paints[i][1], paints[i][3] + 1):
                if paper[r][c] == 1 and color == 2:   # if paper[r][c] == 2 and color == 1: 를 고려하지 못함
                    paper[r][c] = 10
                else:
                    paper[r][c] = color

    for row in range(len(paper)):
        for col in range(len(paper[row])):
            if paper[row][col] == 10:
                count2 += 1

    print(f"#{tc} {count2}")

# # ver 2

# T = int(input())
# for tc in range(1, T + 1):
#     paper = [[0]*10 for i in range(10)]
#     count2 = 0
#
#     N = int(input())
#     for _ in range(N):
#         r1, r2, c1, c2, color = map(int, input().split())
#
#         for i in range(r1, c1 + 1):
#             for j in range(r2, c2 + 1):
#                 if color == 1:
#                     if paper[i][j] == 2:
#                         count2 += 1
#                     paper[i][j] = 1
#                 elif color == 2:
#                     if paper[i][j] == 1:
#                         count2 += 1
#                     paper[i][j] = 2
#
#     print(f"#{tc} {count2}")


