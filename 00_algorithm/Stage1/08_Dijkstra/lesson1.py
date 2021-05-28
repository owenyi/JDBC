# Floyd Warshall

import sys
input = sys.stdin.readline

# INF = sys.maxsize
INF = int(1e9) # 무한을 의미하는 값으로 10억을 설정

# 노드의 개수 및 간선의 개수 입력받기
n, m = map(int, input().split())
# 2차원 리스트(그래프 표현)를 만들고, 무한으로 초기화
graph = [[INF] * (n + 1) for _ in range(n + 1)]

# 자기 자신으로 가는 비용은 0으로 초기화
for i in range(1, n + 1):
    for j in range(1, n + 1):
        if i == j: graph[i][j] = 0

# 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
for _ in range(m):
    # a-b연결 c는 cost
    a, b, c = map(int, input().split())
    graph[a][b] = c
    # graph[b][a] = c # 양방향 노드면 주석 제거

# 점화식에 따라 플로이드 워셜 알고리즘을 수행
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

# 수행된 결과를 출력
for i in range(1, n + 1):
    for j in range(1, n + 1):
        if graph[i][j] == INF: print("INFINITY", end=" ")
        else: print(graph[i][j], end=" ")
    print()