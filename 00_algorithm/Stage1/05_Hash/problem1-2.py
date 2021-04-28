# 15829 Hashing 100점

import sys
input = sys.stdin.readline

r = 31; M = 1234567891;
L = int(input())
s = input()
rPower = 1
result = 0
for i in range(L):
    result = (result + (ord(s[i]) - 96) * rPower % M) % M
    rPower = rPower * r % M
print(result)