for tc in range(1, int(input()) + 1):
    con, truck = map(int, input().split())
    cons = list(map(int, input().split()))
    cons.sort(reverse=True)
    trucks = list(map(int, input().split()))
    trucks.sort(reverse=True)

    c = 0
    t = 0
    kilo = 0
    while t < truck and c < con:
        if trucks[t] >= cons[c]:
            t += 1
            kilo += cons[c]
            c += 1
            
        else:
            c += 1

    print(f'#{tc} {kilo}')
        







