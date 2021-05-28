# Dijkstra

import sys
input = sys.stdin.readline

# INF = sys.maxsize
INF = int(1e9) # 무한을 의미하는 값으로 10억을 설정

# 노드의 개수, 간선의 개수 입력받기
n, m = map(int, input().split())
# 시작 노드 번호를 입력받기
start = int(input())
# 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
graph = [[] for i in range(n + 1)] # [[]] * (n + 1) 하면 안 됨, 깊은복사
# 방문한 적이 있는지 체크하는 목적의 리스트를 만들기
visited = [False] * (n + 1)
# 최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] * (n + 1)

# 모든 간선 정보를 입력 받기
for _ in range(m):
    # a-b연결 c는 cost
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    # graph[b].append((a, c)) # 양방향 노드면 주석 제거

def dijkstra(start):
    # 시작 노드에 대해 초기화
    distance[start] = 0
    visited[start] = True
    for g in graph[start]:
        distance[g[0]] = g[1]
    # 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
    for i in range(n - 1):
        # 현재 거리가 가장 짧은 노드를 꺼내서 방문 처리
        now = get_smallest_node()
        visited[now] = True
        for g in graph[now]:
            cost = distance[now] + g[1]
            # 현재 노드를 거쳐서 g[0]으로 이동하는 거리가 더 짧은 경우
            if cost < distance[g[0]]:
                distance[g[0]] = cost

# 방문하지 않은 노드 중 거리가 가장 짧은 노드 번호를 반환
def get_smallest_node():
    _min, min_idx = INF, 0
    for i in range(1, n + 1):
        if not visited[i] and distance[i] < _min:
            _min, min_idx = distance[i], i
    return min_idx

# 다익스트라 알고리즘 수행
dijkstra(start)

# 모든 노드로 가기 위한 최단 거리를 출력
for i in range(1, n + 1):
    if distance[i] == INF: print("INFINITY")
    else: print(distance[i])

'''
6 9
1
1 2 7
1 5 3
1 6 10
2 3 4
2 4 10
2 5 2
2 6 6
3 4 2
4 5 11
'''