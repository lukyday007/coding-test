for tc in range(1, int(input()) + 1):
    bi = []
    for i in range(1, 13):
        bi.append(2 ** (-i))

    n = float(input())
    result = ""
    for b in bi:
        if n >= b:
            result += "1"
            n -= b
        else:
            result += "0"

        if n == 0:
            break
    if n > 0:
        result = "overflow"
    print(f"#{tc} {result}")