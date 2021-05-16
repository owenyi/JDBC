# 정수 삼각형

def solution(triangle):
    memo = [triangle[0]]
    for i in range(1, len(triangle)):
        nxt = [memo[i-1][0] + triangle[i][0]]
        for j in range(1, i):
            nxt.append(max(memo[i-1][j-1], memo[i-1][j]) + triangle[i][j])
        nxt.append(memo[i-1][-1] + triangle[i][-1])
        memo.append(nxt)
    return max(memo[-1])

triangle = [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]
print(solution(triangle))