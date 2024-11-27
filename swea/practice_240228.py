# 그리디 : 화장실 대기 시간 
times = [15, 30, 50, 10]
times.sort(reverse=True)
totalTime = 0
for i in range(len(times)):
    totalTime += times[i] * i

print('totalTime:', totalTime)


# 조합 
arr = 'ABCD'
n = len(arr)
R = 3
pick = [0] * R

def comb(k, start):
    if k == R:
        print(*pick)
        return 

    for i in range(start, n): 
        # 두 번째 요소를 선택 
        pick[k] = arr[i]
        comb(k + 1, i + 1)
    
comb(0, 0)






