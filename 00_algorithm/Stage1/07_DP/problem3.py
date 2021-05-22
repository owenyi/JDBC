def solution(N, number):
    dp = [-1]
    for i in range(1, 9):
        dp_i = {int(str(N) * i)}
        for j in range(1, i):
            for x in dp[j]:
                for y in dp[i -j]:
                    dp_i.add(x + y)
                    dp_i.add(x - y)
                    dp_i.add(x * y)
                    if y != 0: dp_i.add(x // y)
        if number in dp_i: return i
        dp.append(dp_i)
    return -1