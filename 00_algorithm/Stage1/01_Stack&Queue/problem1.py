# 주식가격

def solution(prices):
    answer = []
    n = len(prices)
    for i in range(n):
        cnt = 0
        for j in range(i + 1, n):
            if prices[i] <= prices[j]:
                cnt += 1
            else:
                cnt += 1
                break
        answer.append(cnt)
    return answer

print(solution([1, 2, 3, 2, 3]))