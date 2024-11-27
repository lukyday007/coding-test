# flattem

# dumpCnt
# boxes_height
import sys  # 나중에 안됨, 제출할 때는 지워야함
sys.stdin = open('flatten.txt')

def flatten(tc, dumpCnt, boxes_height):
    while dumpCnt > 0 :
        high = 0
        high_idx = 0
        low = 10000
        low_idx = 0
        for i in range(len(boxes_height)):
            if boxes_height[i] > high:
                high = boxes_height[i]
                high_idx = i
            if boxes_height[i] < low:
                low = boxes_height[i]
                low_idx = i
        boxes_height[high_idx] -= 1
        boxes_height[low_idx] += 1
        dumpCnt -= 1

    M = 0
    m = 10000
    for box in range(len(boxes_height)):
        if boxes_height[box] > M:
            M = boxes_height[box]

        if boxes_height[box] < m:
            m = boxes_height[box]
    return f"#{tc + 1} {M - m}"

for tc in range(10):
    dumpCnt = int(input())
    boxes_height = list(map(int, input().split()))
    print(flatten(tc, dumpCnt, boxes_height))

# ver2 : 예워닝 코드
for x in range(1, 11):
    N = int(input())
    lst = list(map(int, input().split()))

    count = [0] * 101
    for i in lst:
        count[i] += 1

    i = 1
    j = 100
    a = 0
    while a < N:
        if count[i] >= 1 and count[j] >= 1:
            count[i] -= 1
            count[i + 1] += 1
            count[j] -= 1
            count[j - 1] += 1
            a += 1
        elif count[i] < 1:
            i += 1
        elif count[j] < 1:
            j -= 1

    if count[i] == 0:
        i += 1
    if count[j] == 0:
        j -= 1
    print(f'#{x} {j - i}')










