# # 최대 힙
# def enq(n):
#     global last
#
#     last += 1       # 마지막 노드 추가 ( 완전 이진 트리 때문 )
#     h[last] = n     # 마지막 노드에 데이터 삽입
#     c = last        # 부모 > 자식 조건 설정 위해
#     p = c // 2      # 부모 번호 계산
#     print(h)
#     while p >= 1 and h[p] < h[c]:   # 부모가 자식보다 작으면
#         h[p], h[c] = h[c], h[p]     # 교환
#         c = p
#         p = c//2
#         print(h)
#
# N = 10              # 필요한 노드 수
# h = [0] * (N+1)     # 최대 힙
# last = 0            # 힙의 마지막 노드 번호
#
# enq(2)
# enq(5)
# enq(3)
# enq(6)
# enq(4)
#
# def deq():
#     global last
#     tmp = h[1]      # 루트의 키값 보관
#     h[1] = h[last]
#     last -= 1
#     p = 1           # 새로 옮긴 루트
#     c = p * 2
#     while c <= last:    # 자식이 있으면
#         if c+1 <= last and h[c] < h[c+1]: # 오른쪽 자식이 있고 더 크다
#             c += 1
#         if h[p] < h[c]:
#             h[p], h[c] = h[c], h[p]
#             p = c
#             c = p * 2
#         else:
#             break
#     return tmp
# while last > 0:
#     print(deq())
#



# 힙의 저장소, H[0]은 사용하지 않음
# 최대 힙
H = [0] * 100
hsize = 0       # 마지막 노드 번호(인데스)이자 전체 노드 수

def push(item):
    global hsize
    # 1. 완전 이진 트리 구조 유지
    hsize += 1
    H[hsize] = item

    # 2. 부모-자식 관계 조정
    p, c = hsize//2, hsize

    # 종료 조건 1 : 부모가 자식보다 클 때
    # 종료 조건 2 : 부모가 0이 되기 전까지 -> 자식이 루트가 됨
    while p > 0 and H[p] < H[c]:
        H[p], H[c] = H[c], H[p]
        p, c = p//2, p

def pop():
    pass


# 파이썬 모듈 heapq , heappush, heappop -> 성능이 제일 좋음
from heapq import heappush, heappop
data = [69, 10, 30, 2, 16, 8, 31, 22]

# 힙 저장소를 리스트로 제공
# - 를 붙이면 최소
# 그냥 쓰면 최대
H = []
for val in data:
    heappush(H, (-val, val))

# while H:
#     print(heappop(H))

'''
(-69, 69)
(-31, 31)
(-30, 30)
(-22, 22)
(-16, 16)
(-10, 10)
(-8, 8)
(-2, 2)
'''

# PriorityQueue -> 데이터가 많으면 느려짐 -> 잘 안씀
#               -> 객체 지향적으로 만들어져 있어서 쓰기엔 편함
from queue import PriorityQueue     # deque 처럼 쓰기
# 멀티 스레드? thread-safer : 멀티 스레드 환경에서 안정적으로 돌아간다
# 프로세스 안에 스레드 있음 -> 운영체제
# 멀티 스레드 : 스레드 동시 작동

Q = PriorityQueue()
for val in data:
    Q.put(val)

# while Q: # 이렇게 체크하면 안됨!
while not Q.empty():
    print(Q.get())








