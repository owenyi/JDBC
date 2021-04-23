# 15829 Hashing 100점

import sys
input = sys.stdin.readline

r = 31; M = 1234567891;
L = int(input())
s = input()
rList = [1]
for i in range(1, L):
    rList.append(rList[i - 1] * 31 % M)
result = 0
for i in range(L):
    result = (result + (ord(s[i]) - 96) * rList[i] % M) % M
print(result)