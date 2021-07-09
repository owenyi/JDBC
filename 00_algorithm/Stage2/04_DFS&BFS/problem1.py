from collections import deque

def dfs(graph, v, answers, length):
    stack = deque([v])
    answer = []
    while stack:
        now = stack.pop()
        if graph
        for next in graph[now]:
            if graph.get(v): stack.append(next)
            else:
                if len(answer) == length: answers.append(answer)
                answer = []

def solution(tickets):
    length = len(tickets) + 1
    graph = dict()
    for a, b in tickets:
        if graph.get(a): graph[a].append(b)
        else: graph[a] = [b]
    answers = []
    answer = []
    dfs(graph, "ICN", answers, length)
    return answer

print(solution([["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]))
print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]))