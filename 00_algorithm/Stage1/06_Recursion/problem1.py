# 10829 이진수변환-재귀...좀 더러움

def toBin(dec, bin=''):
    if dec == 1: return int('1' + bin)
    bin = str(dec % 2) + bin
    return toBin(dec // 2, bin)

N = int(input())
print(toBin(N))