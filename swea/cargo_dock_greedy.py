
# for tc in range(1, int(input()) + 1):
#     cargo = []
#     for _ in range(int(input())):
#         a, b = map(int, input().split())
#         cargo.append([b, a])
#     cargo.sort(key=lambda x: x[1], reverse=True)

#     t = []
#     for i in range(len(cargo)-1):
#         if i == 0:
#             t.append(cargo[i])

#         if t and t[-1][1] >= cargo[i][0]:
#             if t[-1][0] >= cargo[i][0]:
#                 t.append(cargo[i])

#     print(f'#{tc} {len(t)}')

cargo = []
for _ in range(int(input())):
    a, b = map(int, input().split())
    cargo.append([b, a])
cargo.sort(key=lambda x: x[1], reverse=True)
print(cargo)

t = []
for i in range(len(cargo)):
    if i == 0:
        t.append(cargo[i])

    if t and t[-1][1] >= cargo[i][0]:
        if t[-1][0] >= cargo[i][0]:
            t.append(cargo[i])

print(t)
print(len(t))












