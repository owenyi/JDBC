# 5692 팩토리얼 진법

from math import factorial

while True:
    fs = input() # factorial scale
    N = len(fs)
    fs = int(fs)
    if fs == 0: break
    ds = 0 # decimal scale
    i = 1; j = N - 1;
    while j >= 0:
        digit = fs % 10
        fs //= 10
        ds += digit * factorial(i)
        i += 1; j -= 1;
    print(ds)