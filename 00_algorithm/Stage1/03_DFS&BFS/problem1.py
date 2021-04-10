# 1260 DFS와 BFS

def DFS(graph, N, start):
    visited[start] = True
    print(start, end=' ')
    for x in graph[start]:
        if visited[x] == False:
            DFS(graph, N, x)

from collections import deque

def BFS(graph, N, start):
    visited = [False for _ in range(N + 1)]
    visited[start] = True
    queue = deque([start])
    while queue: # len(queue) > 0 이랑 똑같음
        now = queue.popleft()
        print(now, end=' ')
        for x in graph[now]:
            if not visited[x]: # visited[x] == False
                visited[x] = True
                queue.append(x)

N, M, start = map(int, input().split())
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
for x in graph: x.sort()

visited = [False for _ in range(N + 1)]
DFS(graph, N, start)

print()

BFS(graph, N, start)