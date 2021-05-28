# 18352 특정 거리의 도시 찾기

n, m, d, start = map(int, input().split())
visited = [False] * (n + 1)
visited[start] = True
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

answers = []

from collections import deque
queue = deque([(start, 0)])
visited[start] = True
while queue:
    now, dist = queue.popleft()
    if dist > d: break
    if dist == d: answers.append(now)
    for g in graph[now]:
        if not visited[g]:
            visited[g] = True
            queue.append((g, dist + 1))

if answers:
    for x in sorted(answers):
        print(x)
else: print(-1)