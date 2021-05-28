# 배달

import sys
input = sys.stdin.readline
INF = sys.maxsize

def solution(N, road, K):

    def smallest_node():  # 방문하지 않은 노드 중 거리가 가장 짧은 노드
        _min, min_idx = INF, 0
        for i in range(1, N + 1):
            if not visited[i] and distance[i] < _min:
                _min, min_idx = distance[i], i
        return min_idx

    answer = 0
    visited = [False] * (N + 1)
    distance = [INF] * (N + 1)
    graph = [{} for i in range(N + 1)] # 중복 더 쉽게 제거할 수 있게 dict로
    # graph = [[] for i in range(N + 1)]
    for a, b, c in road: # 이 부분 때문에
        if graph[a].get(b) and graph[a][b] < c: # 비용이 다른 같은 엣지가 있을 수 있다
            continue
        else:
            graph[a][b] = c
            graph[b][a] = c

    # start 지점에 대한 초기화
    distance[1] = 0 # 이거 빼먹었음
    visited[1] = True
    for b, c in graph[1].items():
        distance[b] = c
    for _ in range(N - 1):
        now = smallest_node()
        visited[now] = True
        for b, c in graph[now].items():
            cost = distance[now] + c
            if cost < distance[b]:
                distance[b] = cost
    for x in distance[1:]: # 처음에는 [1:]로 했는데 answer를 1로 바꾸고 [2:]로 했다
        if x <= K: answer += 1

    return answer

print(solution(6, [[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]], 4))