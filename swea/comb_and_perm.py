# # 조합 

# candidates = ['a','b','c','d','e']
# n = len(candidates)
# # ver 1
# for i in range(n):
#     for j in range(n):
#         for k in range(n):
#             if i < j and j < k:
#                 print(candidates[i], candidates[j], candidates[k])

# # ver 2
# for a in range(n):
#     s1 = a + 1
#     for b in range(s1, n):
#         s2 = b + 1
#         for c in range(s2, n):
#             print(candidates[a], candidates[b], candidates[c])

# # ver 3
# limit = 3
# path = []
# def run(lv, start):
#     if lv == limit:
#         print(path)
#         return
    
#     for i in range(start, 5):
#         path.append(candidates[i])
#         run(lv + 1, i + 1)
#         path.pop()

# run(0, 0)


# challenge 1





