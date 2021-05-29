# 2579 계단오르기

N = int(input())
memo = [[0, 0] for _ in range(3)]
for i in range(3, N + 3):
    _in = int(input())
    memo.append([max(memo[i - 2]) + _in, memo[i - 1][0] + _in])
print(max(memo[-1]))

# N = int(input())
# fst = int(input())
# memo = [[0, 0], [fst, fst]]
# for i in range(2, N + 1):
#     nxt = int(input())
#     memo.append([max(memo[i - 2]) + nxt, memo[i - 1][0] + nxt])
# print(max(memo[-1]))