# 10829 이진수변환-재귀

def toBin(n):
    if n <= 1: return str(n % 2)
    return toBin(n // 2) + str(n % 2)

N = int(input())
print(toBin(N))