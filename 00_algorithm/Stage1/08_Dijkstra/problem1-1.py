# 배달 - priority queue

import sys
input = sys.stdin.readline
import heapq
INF = sys.maxsize

def solution(N, road, K):
    q = []
    graph, distance = [{} for _ in range(N + 1)], [INF] * (N + 1)
    for a, b, c in road:
        if graph[a].get(b) and graph[a][b] < c:
            continue
        else:
            graph[a][b] = c
            graph[b][a] = c

    heapq.heappush(q, (0, 1))
    distance[1] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist: continue
        for b, c in graph[now].items():
            cost = distance[now] + c
            if cost < distance[b]:
                distance[b] = cost
                heapq.heappush(q, (cost, b))

    answer = 0
    for d in distance[1:]:
        if d <= K: answer += 1
    return answer

print(solution(6, [[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]], 4))