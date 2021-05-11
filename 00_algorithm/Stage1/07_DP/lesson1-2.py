# 피보나치 수열-Top Down-Memoization

memo = {0: 1, 1: 1}

def fib(n):
    if n in memo:
        return memo[n]
    else:
        result = fib(n - 1) + fib(n - 2)
        memo[n] = result
        return result

for i in range(10):
    print(i, fib(i))