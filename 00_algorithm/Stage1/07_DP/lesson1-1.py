# 피보나치 수열-Top Down

def fib(n):
    if n in [0, 1]: return 1
    return fib(n - 1) + fib(n - 2)

for i in range(10):
    print(i, fib(i))