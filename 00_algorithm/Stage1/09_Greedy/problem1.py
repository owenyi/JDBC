# 체육복

def solution(n, lost, reserve):
    answer = [1] * (n + 1)
    for x in lost: answer[x] -= 1
    for x in reserve: answer[x] += 1
    for i in range(len(answer)):
        if answer[i] == 0:
            if answer[i - 1] == 2:
                answer[i - 1] -= 1
                answer[i] += 1
            # 1. elif 아닌 if로 해서 틀림
            # 2. i < len(answer) - 1 조건 빼먹어서 틀림
            elif i < len(answer) - 1 and answer[i + 1] == 2:
                answer[i + 1] -= 1
                answer[i] += 1
    return n - answer.count(0)

print(solution(5, [2, 4], [1, 3, 5]))
print(solution(5, [2, 4], [3]))
print(solution(3, [3], [1]))

def solution(n, lost, reserve):
    lost, reverse = list(set(lost) - set(reserve)), list(set(reserve) - set(lost))
    i = 0
    answer = n - len(lost)
    try:
        for l in lost:
            while reserve[i] < l - 1: i += 1
            if reserve[i] == l - 1 or reserve[i] == l + 1:
                answer += 1
                i += 1
            elif reserve[i] > l + 1:
                continue
        return answer
    except: return answer