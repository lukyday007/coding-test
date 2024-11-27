import sys
sys.stdin = open("sudoku.txt")

def correct_or_not(lst):
    # 가로, 세로
    for r in range(9):
        sum_row = 0
        sum_col = 0
        for c in range(9):
            sum_row += sudoku[r][c]
            sum_col += sudoku[c][r]
        if sum_row != 45:
            return False

    # 3x3
    for r in range(0, 7, 3):
        for c in range(0, 7, 3):
            threeby3 = 0
            for row in range(r, r + 3):
                for col in range(c, c + 3):
                    threeby3 += sudoku[row][col]
            if threeby3 != 45:
                return False

    return True

T = int(input())
for tc in range(1, T+1):
    sudoku = [list(map(int, input().split())) for _ in range(9)]
    result = 0

    if correct_or_not(sudoku) == False:
        result = 0
    else:
        result = 1

    print(f"#{tc} {result}")
