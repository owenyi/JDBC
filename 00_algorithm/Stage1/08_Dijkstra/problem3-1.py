# 가장 먼 노드 - bfs

from collections import deque

def solution(n, edge):
    visited = [False] * (n + 1)
    graph = [[] for _ in range(n + 1)]
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)

    visited[1] = True
    q = deque([1])
    while q:
        now = q.popleft()
        for x in graph[now]:
            if not visited[x]:
                answer = len(q) + 1
                q.append(x)
                visited[x] = True
    return answer

print(solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]))