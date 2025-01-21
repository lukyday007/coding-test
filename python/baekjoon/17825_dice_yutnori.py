# 주사위 윷놀이 
# ver 1 : 2차원 배열로 경로 설정 => 포기 
board = [[0] + [0 for _ in range(22)] + [-1] for _ in range(4)]
point10 = [13, 16, 19, 25, 30, 35, 40]
point20 = [22, 24, 25, 30, 35, 40]
point30 = [28, 27, 26, 25, 30, 35, 40]
for i in range(2, 41, 2):
    board[0][i//2] = i

for j in range(len(board[0])):
    if board[0][j] == 10:
        board[1][j+1 : j + 1 + len(point10)] = point10[:]

for j in range(len(board[0])):
    if board[0][j] == 20:
        board[2][j+1 : j + 1 + len(point20)] = point20[:]

for j in range(len(board[0])):
    if board[0][j] == 30:
        board[3][j+1 : j + 1 + len(point30)] = point30[:]

for i in range(4):
    for j in range(len(board[i]) - 2, 0, -1):
        if board[i][j] != 0:
            break
        board[i][j] = -1


# ver 2 : 인접리스트로 경로 만들기 
# 112136kb, 204ms 
matrix = [
    [1], [2], [3], [4], [5], [6, 21], [7], [8], [9], [10], 
    [11, 24], [12], [13], [14], [15], [16, 26], [17], [18], [19], [20], 
    [32], [22], [23], [29], [25], [29], [27], [28], [29], [30], 
    [31], [20], [32], [32], [32], [32], [32]
    ]
scores = [
    0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 
    20, 22, 24, 26, 28, 30, 32, 34, 36, 38,
    40, 13, 16, 19, 22, 24, 28, 27, 26, 25, 
    30, 35, 0, 0, 0, 0, 0
]
pieces = [0 for _ in range(4)]
maxV = 0

def dfs(N, total):
    global maxV 

    if N == 10:
        maxV = max(maxV, total)
        return 

    for p in range(4):
        point = pieces[p]   
        # 시작시 한 칸 이동 : matrix[0] = [1] 인접행렬의 인덱스 위치 값은 이미 이동한 값을 나타내고 있음 
        move = matrix[point][-1]

        for _ in range(1, arr[N]):  # 지나가는 거면 [point][0]으로 처리 
            move = matrix[move][0]

        if move == 32 or move not in pieces:
            pieces[p] = move
            dfs(N + 1, total + scores[move])
            pieces[p] = point

arr = list(map(int, input().split()))
dfs(0, 0)
print(maxV)
