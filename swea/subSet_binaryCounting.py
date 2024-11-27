# 비트 연산자 
# practice 1
arr = ['a', 'b', 'c']
n = len(arr)

def get_sub(tar):
    for i in range(n):
        if tar & 0x1:
            print(arr[i], end="")
        tar >>= 1


for tar in range(0, 1<<n):
    print('{', end='')
    get_sub(tar)
    print('}')

# practice 2
friends = ['a','b','c','d','e','f']
length = len(friends)

def make_group(friend):
    cnt = 0
    for i in range(length):
        # 1 비트인지 확인 
        if friend & 0x1:
            cnt += 1
        # right shift 비트 연산자 -> 오른쪽 끝 비트를 하나씩 제거 
        friend >>= 1
    return cnt 

result = 0
for friend in range(1 << length):
    if make_group(friend) >= 2:
        result += 1
print(result)