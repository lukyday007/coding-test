import sys
sys.stdin = open('inorder.txt')

for tc in range(1, 11):
    N = int(input())
    node_dict = {}
    info = [list(map(str, input().split()))for _ in range(N)] # 정점, 문자, 왼쪽, 오른쪽
    for i in range(N):
        node_dict[int(info[i][0])] = info[i][1]

    L = [0] * (N + 1)
    R = [0] * (N + 1)
    P = [0] * (N + 1)

  # 완전 이진트리 노드수, 마지막 노드
    def inorder(v):
        if v > N:
            return

        inorder(v * 2)
        print(node_dict[v], end='')
        inorder(v * 2 + 1)
    print(f"#{tc}", end=" ")

    inorder(1)
    print()



