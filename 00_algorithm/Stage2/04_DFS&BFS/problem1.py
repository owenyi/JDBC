# 여행경로

def dfs(graph, check, paths, path, v, cnt, length):
    if cnt == length:
        paths.append(path.copy())
        return
    if not graph.get(v): return
    for i, next in enumerate(graph[v]):
        if check[v][i]: continue
        check[v][i] = True
        path.append(next)
        dfs(graph, check, paths, path, next, cnt + 1, length)
        check[v][i] = False
        del path[-1]

def solution(tickets):
    length = len(tickets) + 1
    graph = dict()
    check = dict()
    for a, b in tickets:
        if graph.get(a):
            graph[a].append(b)
            check[a].append(False)
        else:
            graph[a] = [b]
            check[a] = [False]

    paths = []
    dfs(graph, check, paths, ["ICN"], "ICN", 1, length)

    paths.sort()

    return paths[0]

print(solution([["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]))
# print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]))