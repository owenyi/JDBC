# 모의고사

def solution(answers):
    answer = []
    p1 = [1, 2, 3, 4, 5, 1, 2, 3, 4, 5]
    p2 = [2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    cnt = [0] * 4
    for i in range(len(answers)):
        if p1[i % len(p1)] == answers[i]: cnt[1] += 1
        if p2[i % len(p2)] == answers[i]: cnt[2] += 1
        if p3[i % len(p3)] == answers[i]: cnt[3] += 1
    maxCnt = max(cnt)
    for i in range(1, 4):
        if cnt[i] == maxCnt: answer.append(i)
    return answer

print(solution([1,2,3,4,5]))
print(solution([1,3,2,4,2]))