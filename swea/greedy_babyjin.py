def get_winner(player):
    for i in range(len(player)):
        if player[i] > 2:
            return 1
        if i + 2 >= len(player): continue
        if player[i] > 0 and player[i + 1] > 0 and player[i + 2] > 0:
            return 1
    return 0

for tc in range(1, int(input()) + 1):
    answer = 0
    cnt = 0
    lst = list(map(int, input().split()))
    p1 = [0] * 10
    p2 = [0] * 10
    while cnt < len(lst):
        if cnt % 2 == 0:
            p1[lst[cnt]] += 1
            res1 = get_winner(p1)
            if res1 > 0:
                answer = 1
                break
        else:
            p2[lst[cnt]] += 1
            res2 = get_winner(p2)
            if res2 > 0:
                answer = 2
                break
        cnt += 1

    print(f'#{tc} {answer}')
