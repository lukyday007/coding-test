# print(0b11011110 & 0b11011)     # 26
# print(0x4A3 | 25)               # 1211
#
#
# print(7070 ^ 1004)      # 6258
# print(6258 ^ 1004)      # 7070
#
#
#
# KEY = 1004
# def encode_decode(num):
#     return num ^ KEY
#
# print(encode_decode(1000))      # 4
# print(encode_decode(4))         # 1000
#
#
# print()
#
# for i in range(5):
#     print(bin(0b1 << i), 0b1 << i)
# '''
# 0b1 1
# 0b10 2
# 0b100 4
# 0b1000 8
# 0b10000 16
# '''
#
# print()
# t = 1101 & (1 << 2)
# print(f"t : {t}")
# if t > 0: print("n번 bit는 1 입니다")
# if t == 0 : print("n번 bit는 0입니다.")
# print()
#
# t = 1101 & (1 << 1)
# print(f"t : {t}")
# if t > 0: print("n번 bit는 1 입니다")
# if t == 0 : print("n번 bit는 0입니다.")


# M = 31
# N = 5
# def Test():
#     tar = M
#     for i in range(N):
#         if tar & 0x1 == 0:
#             return False
#         tar = tar >> 1
#     return True
# print(Test())       # True
# print(0x1)          # 1
# print(bin(31))      # 0b11111


t1 = 10
t2 = 3.141592

print(f"변수 값은 {t1} 입니다")        # 변수 값은 10 입니다
print(f"변수 값은 {t2:.2f} 입니다")    # 변수 값은 3.14 입니다

t = 0.1
print(f"{t:.20f}")  #0.10000000000000000555







