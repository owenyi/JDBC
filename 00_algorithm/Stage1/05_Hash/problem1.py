# 15829 Hashing 50점

r = 31; M = 1234567891;
L = int(input())
s = input()
result = 0
for i in range(L):
    result += ((ord(s[i]) - 96) * r**i) % M
print(result)