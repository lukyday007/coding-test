def func(k):
    global minVal 

    if k > N + 2:
        return 

    if 0 not in bits[2:]:
        # for b in range(len(bits) - 1):
        # print(bits[2:])
        tmp = 0
        for b in range(len(bits) - 1):
            if b == 0:
                tmp += abs(G[0][0] - G[bits[b]][0]) + abs(G[0][1] - G[bits[b]][1])
            tmp += abs(G[bits[b]][0] - G[bits[b + 1]][0]) + abs(G[bits[b]][1] - G[bits[b + 1]][1])
        tmp += abs(G[bits[-1]][0] - G[1][0]) + abs(G[bits[-1]][1] - G[1][1])
        minVal = min(minVal, tmp)
        
    for i in range(2, N + 2):
        if bits[i] == 0 and k < N + 2:
            bits[i] = k
            func(k + 1)
            bits[i] = 0
    
for tc in range(1, int(input()) + 1):
    N = int(input())
    G = [[] for _ in range(N + 2)]
    lst = list(map(int, input().split()))
    minVal = 21e18

    for j in range(0, 2 * N + 3, 2):
        G[j//2].append(lst[j])
        G[j//2].append(lst[j + 1])

    bits = [0] * (N + 2)
    func(2)
    print(f'#{tc} {minVal}')















