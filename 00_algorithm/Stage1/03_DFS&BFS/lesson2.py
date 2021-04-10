# BFS 최단경로찾기

start = 1 # 시작섬
end = 12 # 도착섬
number = 12 # 섬의 갯수
data = [[1, 2], [1, 5], [1, 6], [2, 3], [2, 11], [3, 6], [3, 7], [3, 8], [4, 8], [4, 12], [5, 6], [5, 9], [5, 11], [6, 12], [7, 10], [7, 8], [8, 11], [9, 10]] # 섬들 사이의 연결

def solution(data, start, end, number):
    answer = 0
    destination = end
    queue = [start]
    visited = [False for i in range(number)]
    visited[start - 1] = True
    while len(queue) > 0:
        count = len(queue)
        for time in range(count):
            now = queue.pop(0) # 현재 검사중인 섬의 위치
            if now == destination:
                return answer
            for i in data:
                if i[0] == now and visited[i[1]-1] == False:
                    queue.append(i[1])
                    visited[i[1]-1] = True
                elif i[1] == now and visited[i[0]-1] == False:
                    queue.append(i[0])
                    visited[i[0]-1] = True
                print(visited)
        answer += 1
    return -1 # 정답이 없을 경우 -1을 반환

print(solution(data, start, end, number))

