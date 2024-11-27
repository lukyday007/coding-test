# 현주의 상자 바꾸기
'''
2
5 2
1 3
2 4
6 2
1 4
3 6
'''
T = int(input())
for tc in range(1, T+1):
    N, Q = map(int, input().split())
    boxes = [0] * (N+1)
    for _ in range(Q):
        l, r = map(int, input().split())
        for i in range(l, r+1):
            boxes[i] = l
    boxes.pop(0)
    print(f"#{tc}", end=" ")
    for j in range(len(boxes)):
        print(boxes[j], end=" ")
    print()

