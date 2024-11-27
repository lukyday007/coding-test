for tc in range(1, 2):
    N = int(input())
    H = [0] * (N + 1)
    L = [0] * (N + 1)
    R = [0] * (N + 1)
    P = [0] * (N + 1)

    # 왼쪽자식, 오른쪽자식 둘 다 0 -> 단말노드
    # 위를 확인하기 위해 배열의 빈 공간이 필요하다
    for _ in range(N):
        num, val, *l = map(str, input().split())
        if len(l) == 2:
            a, b = l
            L[int(num)] = int(a)
            R[int(num)] = int(b)
        if val.isnumeric():
            H[int(num)] = int(val)
            P[int(num)] = int(val)
        else:
            H[int(num)] = val
            P[int(num)] = val
    print(H)
    print(L)
    print(R)
    print(P)

    def postorder(v):
        # 단말 노드인 경우 v == 0에 걸려서 0이 리턴 됨
        if v == 0 or v > N:
            return 0
        if isinstance(H[v], int):  
            return H[v]

        left = postorder(L[v])
        right = postorder(R[v])

        if H[v] in '+-/*':
            if H[v] == "+":
                return left + right 
            elif H[v] == "-":
                return left - right
            elif H[v] == "/":
                return left // right
            elif H[v] == "*":
                return left * right


    print(f'#{tc} {postorder(1)}')


