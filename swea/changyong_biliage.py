from collections import deque

for tc in range(1, int(input())+1):
    N, M = map(int, input().split())
    G = [[] for _ in range(N+1)]
    Q = deque()
    visited = [0] * (N+1)
    visited[0] = -1

    for i in range(M):
        a, b = map(int, input().split())
        G[a].append(b)
        G[b].append(a)

    def BFS(start, cnt):
        Q.append(start)
        visited[start] = cnt

        while Q:
            v = Q.popleft()
            for w in G[v]:
                if visited[w] == 0:
                    visited[w] = cnt
                    Q.append(w)
    cnt = 1

    for i in range(len(visited)):
        if visited[i] == 0:
            BFS(i, cnt)
            cnt += 1

    print(f"#{tc} {max(visited)}")