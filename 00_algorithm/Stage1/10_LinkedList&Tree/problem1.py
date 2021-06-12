from collections import deque

def solution(priorities, location):
    answer = 0
    queue = deque([(p, i) for i, p in enumerate(priorities)])
    while True:
        item = queue.popleft()
        if queue and item[0] < max(queue)[0]:
            queue.append(item)
        else:
            answer += 1
            if item[1] == location: break
    return answer

print(solution([2, 1, 3, 2], 2))
print(solution([1, 1, 9, 1, 1, 1], 0))