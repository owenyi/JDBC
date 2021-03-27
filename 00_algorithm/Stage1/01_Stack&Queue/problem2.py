# 기능개발

from math import ceil

def solution(progresses, speeds):
    answer = [] # 배포
    complete = [] # 완성까지 걸리는 시간
    queue = []
    n = len(progresses)
    for i in range(n):
        a = (100 - progresses[i]) / speeds[i]
        complete.append(ceil(a))
    for x in complete:
        nQ = len(queue)
        if nQ != 0 and queue[0] < x:
            answer.append(nQ)
            queue.clear()
            queue.append(x)
        else:
            queue.append(x)
    answer.append(len(queue))
    return answer

print(solution([93, 30, 55], [1, 30, 5]))
print(solution([95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1]))