N = int(input())
bits = [0] * (N + 1)
arr = [list(map(int, input().split())) for _ in range(N)]

def DFS(start):
