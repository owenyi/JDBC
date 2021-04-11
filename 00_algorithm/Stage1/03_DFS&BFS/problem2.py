# 2606 바이러스 DFS

from collections import deque

N = int(input())
graph = [[] for _ in range(N + 1)]
M = int(input())
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

start = 1
stack = deque([start])
visited = [False for _ in range(N + 1)]
visited[start] = True
# cnt = 0
while stack:
    now = stack.pop()
    for x in graph[now]:
        if not visited[x]:
            stack.append(x)
            visited[x] = True
            # cnt += 1

# print(cnt)
print(visited.count(True) - 1)