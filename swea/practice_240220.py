# # 전위
# V = int(input())
# arr = list(map(int, input().split()))
# E = V - 1
#
# # 1번 부터 V번
# L = [0] * (V + 1)
# R = [0] * (V + 1)
# P = [0] * (V + 1)
# # 왼쪽자식, 오른쪽자식 둘 다 0 -> 단말노드
# # 위를 확인하기 위해 배열의 빈 공간이 필요하다
# for i in range(0, 2*E, 2):
#     parent, child = arr[i], arr[i+1]
#     # parent의 왼쪽 child(L[p])를 확인
#     if L[parent] == 0:
#         L[parent] = child
#     else:   # p의 오른쪽 자식 (R[p])
#         R[parent] = child
#     # child의 부모 P[child]를 p로 저장
#     P[child] = parent
#


arr = list(map(int, input().split()))
E = 5
V = E + 1
# 1번 부터 V번
L = [0] * (V + 1)
R = [0] * (V + 1)
P = [0] * (V + 1)  #
# 왼쪽자식, 오른쪽자식 둘 다 0 -> 단말노드
# 위를 확인하기 위해 배열의 빈 공간이 필요하다
for i in range(0, 2 * E, 2):
    parent, child = arr[i], arr[i + 1]
    # parent의 왼쪽 child(L[p])를 확인
    if L[parent] == 0:
        L[parent] = child
    else:  # p의 오른쪽 자식 (R[p])
        R[parent] = child
    # child의 부모 P[child]를 p로 저장
    P[child] = parent
print(L)
print(R)
print(P)

cnt = 0
def inorder(v): # v: 부모 노드
    global cnt
    # 재귀 호출 종료, 공백 노드 체크
    if v == 0:
        return
    # 처음 진입한 경우 -- 전위
    cnt += 1

    # 계속 재귀 호출
    # inorder(왼쪽자식)
    inorder(L[v])

    # 왼쪽 자식에서 돌아온 후 -- 중위
    # inorder(오른쪽자식)
    inorder(R[v])

    # 오른쪽 자식에서 돌아온 후 -- 후위

inorder(1)
print(cnt)

######### 재귀 호출로 깊이 푸는 법 ##########
# 서브 트리 개수 세기
def tree_size(v):           # v: 부모 노드
    if v == 0:              # base condition, 기저 조건
        return 0

    l = tree_size(L[v])
    r = tree_size(R[v])
    # 후위 순회 방식 : 왼쪽 서브 트리 방문 끝 + 오른쪽 서브 트리 방문 끝 + 부모 노드
    return l + r + 1

# 중위


# 후위