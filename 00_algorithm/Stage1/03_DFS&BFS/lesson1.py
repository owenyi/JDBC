# DFS 미로찾기

maps = [[0, 0, 0, 0, 0, 0],
        [1, 0, 1, 1, 1, 0],
        [0, 0, 1, 0, 1, 0],
        [0, 1, 1, 0, 0, 0],
        [0, 0, 1, 1, 1, 1],
        [1, 0, 0, 0, 0, 0]]

start = [0, 0]

def solution(maps, start):
    stack = [start]; maps[start[1]][start[0]] = 1;
    xLen, yLen = len(maps), len(maps[0])
    dest = [yLen - 1, xLen - 1]
    while len(stack) > 0:
        now = stack.pop()
        if now == dest:
            return True
        y, x = now
        print(y, x)
        if x - 1 > -1: # 왼쪽으로 갈 수 있다면
            if maps[y][x - 1] == 0: # 갈 수 있는 길이라면
                stack.append([y, x - 1])
                maps[y][x - 1] = 1
        if x + 1 < xLen:
            if maps[y][x + 1] == 0:
                stack.append([y, x + 1])
                maps[y][x + 1] = 1
        if y - 1 > -1:
            if maps[y - 1][x] == 0:
                stack.append([y - 1, x])
                maps[y - 1][x] = 1
        if y + 1 < yLen:
            if maps[y + 1][x] == 0:
                stack.append([y + 1, x])
                maps[y + 1][x] = 1
    return False

print(solution(maps))



