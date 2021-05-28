# Dijkstra - priority queue

import sys
input = sys.stdin.readline

import heapq # heapq가 priority queue보다 성능이 좋다고 함

INF = int(1e9) # 무한을 의미하는 값으로 10억을 설정

n, m = map(int, input().split())
start = int(input())
distance = [INF] * (n + 1)
graph = [[] for i in range(n + 1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    # graph[b].append((a, c)) # 양방향 노드면 주석 제거

def dijkstra(start):
    q = []
    # 시작 노드에 대해 초기화
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist: continue
        for g in graph[now]:
            cost = dist + g[1]
            # 현재 노드를 거쳐서 g[0]으로 이동하는 거리가 더 짧은 경우
            if cost < distance[g[0]]:
                distance[g[0]] = cost
                heapq.heappush(q, (cost, g[0]))

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