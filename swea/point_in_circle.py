# 원 안의 점

T = int(input())
for tc in range(1, T+1):
    r = int(input())
    ratio = 3.14
    cnt = 0
    for i in range(-r, r + 1):
        for j in range(-r, r + 1):
            if i*i + j*j <= r*r:
                cnt += 1

    print(f"#{tc} {cnt}")











