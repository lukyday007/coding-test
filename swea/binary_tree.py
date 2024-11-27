# 완전 이진 트리
# 따로 노드 번호를 저장할 필요가 없다

for tc in range(1, int(input())+1):
    N = int(input())
    D = [0] * (N+1)
    cnt = 1

    def inorder(v): # v 는 노드 번호이자 인덱스
        global cnt  # 방문 차례
        if v > N :
            return

        inorder(v*2)
        # D[v] = cnt
        # cnt += 1
        inorder(v*2 + 1)

    inorder(1)
    print(D)
    print(f"#{tc} {D[1]} {D[N//2]}")