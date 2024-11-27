def enq(n):
    global last

    last += 1       # 마지막 노드 추가 ( 완전 이진 트리 때문 )
    h[last] = n     # 마지막 노드에 데이터 삽입
    c = last        # 부모 > 자식 조건 설정 위해
    p = c // 2      # 부모 번호 계산

    # 최소 힙
    while p >= 1 and h[p] > h[c]:   # 부모가 자식보다 작으면
        h[p], h[c] = h[c], h[p]     # 교환
        c = p
        p = c//2

for tc in range(1, int(input()) + 1):
    N = int(input())              # 필요한 노드 수
    h = [0] * (N+1)     # 최대 힙
    last = 0            # 힙의 마지막 노드 번호
    for i in list(map(int, input().split())):
        enq(i)

    idx = len(h) - 1
    total = 0
    while idx > 0:
        idx //= 2
        total += h[idx]

    print(f"#{tc} {total}")
