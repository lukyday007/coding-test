# def binary_search_recur(arr, lo, hi, key):
#     if lo >= hi:
#         return -1
#     mid = (lo + hi) >> 1
#     if arr[mid] == key:
#         return mid
#     elif arr[mid] > key:
#         return binary_search_recur(arr, lo, mid - 1, key)
#     else:
#         return binary_search_recur(arr, mid + 1, hi, key)
#
#
# arr = [8, 11, 16, 28, 39, 49, 60, 67, 85, 89]
# N = len(arr)
# print(binary_search_recur(arr, 0, N - 1, 67))
# print(binary_search_recur(arr, 0, N - 1, 68))

# ver 1
# cnt = 0
# def binary_pages(low, high, n):
#     global cnt
#
#     if low >= high:
#         return -1, cnt
#     cnt += 1
#     mid = (low + high) >> 1
#
#     if mid == n:
#         return - 1, cnt
#     elif mid > n:
#         return binary_pages(low, mid - 1, n)
#     else:
#         return binary_pages(low, mid + 1, n)
#
# T = int(input())
# for tc in range(1, T+1):
#     pages, p1, p2 = list(map(int, input().split()))
#     answer = ""
#     result1, c1 = binary_pages(0, pages, p1)
#     cnt = 0
#     result2, c2 = binary_pages(0, pages, p2)
#
#     if c1 > c2:
#         answer = 'A'
#     elif c1 < c2:
#         answer = 'B'
#     else:
#         answer = '0'
#
#     print(f"#{tc} {answer}")

# # ver 2 ( mid + 1, mid - 1 하면 안된다!!!!! )
# def binary_pages(low, high, key, cnt):
#     if low > high:
#         return cnt
#
#     mid = (low + high) >> 1
#
#     if mid == key:
#         return cnt
#     elif mid > key:
#         return binary_pages(low, mid, key, cnt + 1)
#     else:
#         return binary_pages(mid, high, key, cnt + 1)
#
# T = int(input())
# for tc in range(1, T + 1):
#     pages, p1, p2 = map(int, input().split())
#     answer = ""
#     c1 = binary_pages(1, pages, p1, 0)
#
#     c2 = binary_pages(1, pages, p2, 0)
#     if c1 > c2:
#         answer = 'B'
#     elif c1 < c2:
#         answer = 'A'
#     else:
#         answer = '0'
#
#     print(f"#{tc} {answer}")

def binary_pages(low, high, key, cnt):
    if low >= high:
        return cnt

    mid = (low + high) //2

    if mid == key:
        return cnt
    elif mid > key:
        return binary_pages(low, mid, key, cnt+1)
    else:
        return binary_pages(mid, high, key, cnt+1)

print(binary_pages(1, 1000, 222, 1))   # low가 1 이여야 함
print(binary_pages(1, 1000, 888, 1))








