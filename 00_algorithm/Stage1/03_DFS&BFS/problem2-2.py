# 2606 바이러스 BFS

from collections import deque

N = int(input())
graph = [[] for _ in range(N + 1)]
M = int(input())
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

start = 1
queue = deque([start])
visited = [False for _ in range(N + 1)]
visited[start] = True
while queue:
    now = queue.popleft()
    for x in graph[now]:
        if not visited[x]:
            queue.append(x)
            visited[x] = True

print(visited.count(True) - 1)