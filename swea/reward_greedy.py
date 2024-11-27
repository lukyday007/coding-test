# num = [3,2,8,8,8]
# print(num)
# for i in range(len(num) - 1):
#     for j in range(i + 1, len(num)):
#         num[i], num[j]= num[j], num[i]
    
#         print(num)

# 숫자판 교환 방법
# 탐욕은 증명이 없으면, 최적해를 찾는 방식이 아니라, 대략적인 접근방법 
# 탐욕은 사전의 방법에서 확신을 가지고 감: 매 순간 답으로 가는 길을 선택 
# 최적화 : 선택에 선택을 이어가는 풀이 
# 1. List에 저장해서 nums[i]와 nums[j] 위치를 교환 
# 5C2

# 2번 교환할 때 
# num 에서 가장 큰 숫자 2개를 선택 -> 방문 처리
#          가장 작은 숫잦 2개를 선택 -> 방문 처리 

num = [3,2,8,8,8]
c= 2
new = num[:]
indexes = []
visit = [0] * len(num)
a = 0
b = 0

for _ in range(c):
    mi = min(new)
    ma = max(new)
    if new.count(mi) > 1:
        for i in range(len(num)):
            if num[i] == mi:
                a = i
                break
    else:
        a = new.index(mi)

    if new.count(ma) > 1:
        for i in range(len(num)-1, -1, -1):
            if num[i] ==ma:
                b = i
                break
    else:
        b = new.index(ma)
    print(a, b)

    num[a], num[b] = num[b], num[a]
    print(num)



print(num)












