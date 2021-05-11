# 이웃하지 않는 숫자의 합 최댓값


def solution(data):
    if len(data) == 1: return data[0]
    result = [data[0], max(data[0], data[1])]
    for i in range(2, len(data)):
        result.append(max(result[i - 1], result[i - 2] + data[i]))
    return result[-1]

data = [3, 4, 5, 6, 1, 2, 5]
print(solution(data))