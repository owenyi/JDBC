# 더 맵게

import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    answer = 0
    while True:
        now = heapq.heappop(scoville)
        if not scoville or now >= K: break
        next = heapq.heappop(scoville)
        heapq.heappush(scoville, now + next * 2)
        answer += 1
    if now >= K: return answer
    return -1

print(solution([1, 2, 3, 9, 10, 12], 7))