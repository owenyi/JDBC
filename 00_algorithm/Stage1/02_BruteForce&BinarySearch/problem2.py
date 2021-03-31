# 소수 찾기

from itertools import permutations
import math

def isPrime(x):
    if x < 2: return False
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0: return False
    return True

def solution(numbers):
    perms = []
    for i in range(1, len(numbers) + 1):
        perm = list(map(''.join, permutations(numbers, i)))
        perms += perm
    perms = list(set(map(int, perms)))
    answer = 0
    for x in perms:
        if isPrime(x): answer += 1
    return answer

print(solution("17"))
print(solution("011"))