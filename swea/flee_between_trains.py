T = int(input())

for tc in range(1, T+1):
    dis, train_A, train_B, flee = list(map(int, input().split()))
    time = dis / (train_A + train_B)
    print(f"#{tc} {time * flee}")