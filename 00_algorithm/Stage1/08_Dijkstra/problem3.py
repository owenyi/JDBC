# 가장 먼 노드 - dijkstra

import heapq

def solution(n, edge):
    graph = [[] for _ in range(n + 1)]
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)
    distance = [50000] * (n + 1)

    q = []
    heapq.heappush(q, (0, 1))
    distance[1] = 0

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist: continue
        for g in graph[now]:
            cost = dist + 1
            if cost < distance[g]:
                distance[g] = cost
                heapq.heappush(q, (cost, g))

    return distance.count(max(distance[1:]))

print(solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]))