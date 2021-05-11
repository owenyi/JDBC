# 피보나치 수열-Bottom Up

def fib(n):
    fibList = [1, 1]
    for i in range(2, n + 1):
        fibList.append(fibList[i - 1] + fibList[i - 2])
    return fibList[-1]

for i in range(10):
    print(i, fib(i))