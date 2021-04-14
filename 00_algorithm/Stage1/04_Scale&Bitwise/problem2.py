# 2745 진법변환

def toDecimal(x):
    try:
        x = int(x)
        return x
    except:
        return ord(x) -55

N, B = input().split()
B = int(B)
i = 1
result = 0
for x in N[::-1]:
    result += toDecimal(x) * i
    i *= B
print(result)