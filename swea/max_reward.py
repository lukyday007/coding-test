def backtrack(k, cnt):
    if cnt > time:
        return
    if cnt == time:

        print(num)
        return 
    
    for i in range(k, len(num)):
        num[i], num[k] = num[k], num[i]
        backtrack(i + 1, cnt + 1)
        num[i], num[k] = num[k], num[i]


num, time = map(int, input().split())
num = list(map(int, list(str(num))))
backtrack(0, 0)

