# 주식가격-스택활용

def solution(prices):
    n = len(prices)
    answer = [0] * n
    stack = [0]
    for i in range(1, n):
        while prices[stack[-1]] > prices[i]:
            j = stack.pop()
            answer[j] = i - j
            if len(stack) == 0: break
        stack.append(i)
    while len(stack) > 0:
        j = stack.pop()
        answer[j] = i - j
    return answer

print(solution([1, 2, 3, 2, 3]))