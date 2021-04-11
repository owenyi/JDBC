# 2606 바이러스 DFS recursion

from collections import deque

def DFS(v):
    for x in graph[v]:
        if not visited[x]:
            visited[x] = True
            DFS(x)

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

DFS(start)
print(visited.count(True) - 1)