# 18258 큐2 - 실패, 시간초과

import sys
input = sys.stdin.readline

queue = []

N = int(input())
for i in range(N):
    line = input().split()
    command = line[0]
    if len(line) == 2: num = line[1]
    if command == "push": queue.append(num)
    elif command == "pop":
        if len(queue): print(queue.pop(0))
        else: print(-1)
    elif command == "size": print(len(queue))
    elif command == "empty":
        if len(queue): print(0)
        else: print(1)
    elif command == "front":
        if len(queue): print(queue[0])
        else: print(-1)
    elif command == "back":
        if len(queue): print(queue[-1])
        else: print(-1)