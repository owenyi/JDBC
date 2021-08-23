#핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
class Solution:
    def solution(self, n, actions):
        graph = [-1] * (n + 1)
        for action in actions:
            cmd = action.split()
            if cmd[0] == "PUT":
                i = int(cmd[1])
                j = int(cmd[3])
                if graph[i] != -1 or graph[j] != -1: return -1  # 바닥에 놓여있지 않다면
                graph[i] = j
            elif cmd[0] == "SET":
                i = int(cmd[1])
                if graph[i] != -1: return -1 # 바닥에 놓여있지 않다면
                for j in range(1, n + 1):
                    if graph[j] == i: graph[j] = -1
            elif cmd[0] == "SWAP":
                i = int(cmd[1])
                j = int(cmd[3])
                if graph[i] != -1 or graph[j] != -1: return -1  # 바닥에 놓여있지 않다면
                for k in range(1, n + 1):
                    if graph[k] == i: graph[k] = j
                    elif graph[k] == j: graph[k] = i
        for child, parent in enumerate(graph):
            if parent != -1 and child > parent: return -1
        return graph.count(-1) - 1

s = Solution()
n = 2
actions = ["PUT 1 INSIDE 2"]
print(s.solution(n, actions))
n = 2
actions = ["PUT 1 INSIDE 2","SET 2 LOOSE"]
print(s.solution(n, actions))
n = 2
actions = ["PUT 2 INSIDE 1"]
print(s.solution(n, actions))
n = 4
actions = ["PUT 3 INSIDE 2","SWAP 4 WITH 2","PUT 2 INSIDE 4","SET 1 LOOSE"]
print(s.solution(n, actions))
n = 3
actions = ["PUT 1 INSIDE 2","PUT 3 INSIDE 1"]
print(s.solution(n, actions))