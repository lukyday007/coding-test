arr = '0000000111100000011000000111100110000110000111100111100111111001100111'

num = [1,2,3,4]
val = 0
for digit in num:
    val = val * 10 + digit
print(val)

b_num = [0,1,0,1,0,0,1]
N = 7
# 그냥 계산
val2 = 0
for b in b_num:
    # val2 = val2 * 2 + b
    val2 = val2 * 2 + (1 if b == 1 else 0)
print(val2)

# 비트 연산자 쓰기
val3= 0
for i in range(N):
    if b_num[i] == 1:
        print(f'i : {i}, N - 1 - i : {N - 1 - i}')
        val3 = val3 | (1 << (N - 1 - i))
print(val3)     # 41

# 라이브러리 사용
binary_string = ''.join(map(str, b_num))
print(int(binary_string, 2))    # 41

print(int('1a', 16))    # 2진수 -> 16진수 = 41
print(bin(10))      # 0b1010

# 비트 연산
a = 0
b = 1 << 2
print(a|b , bin(a|b))   # 4 0b100
