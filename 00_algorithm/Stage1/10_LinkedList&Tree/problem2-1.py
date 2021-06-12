# 더 맵게 - 덜 지저분하게

import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    answer = 0
    while True:
        now = heapq.heappop(scoville)
        if now >= K: break
        elif not scoville: return -1
        next = heapq.heappop(scoville)
        heapq.heappush(scoville, now + next * 2)
        answer += 1
    return answer