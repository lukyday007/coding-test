# def sequential_search(a, n, key):
#     i = 0
#     while i < n and a[i] != key:
#         i = i + 1
#     if i < n:
#         return i
#     else:
#         return -1
#
# # Test the function
# arr = [3, 5, 2, 8, 9, 4]
# element_to_find = 8
# result = sequential_search(arr, len(arr), element_to_find)
# if result != -1:
#     print(f"Element found at index {result}")
# else:
#     print("Element not found")
# print()

# # 이진 검색 by 재귀함수
def binarySearch2(a, low, high, key):
    if low > high:
        return False
    else:
        middle = (low + high) // 2
        if key == a[middle]:
            return True
        elif key < a[middle]:
            return binarySearch2(a, low, middle - 1, key)
        elif a[middle] < key:
            return binarySearch2(a, middle + 1, high, key)

# Test the binary search function
arr = [1, 3, 5, 7, 9, 11, 13, 15]
key = 3

# The array should be sorted for binary search
result = binarySearch2(arr, 0, len(arr) - 1, key)

if result:
    print(f"Element {key} found in the array: index {arr.index(key)}")
else:
    print(f"Element {key} not found in the array")









