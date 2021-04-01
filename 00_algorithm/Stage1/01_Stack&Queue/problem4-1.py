# 10828 스택 - 함수 없이

import sys
input = sys.stdin.readline

stack = []

N = int(input())
for i in range(N):
    line = input().split()
    command = line[0]
    if len(line) == 2: num = line[1]
    if command == "push": stack.append(num)
    elif command == "pop":
        if len(stack): print(stack.pop())
        else: print(-1)
    elif command == "size": print(len(stack))
    elif command == "empty":
        if len(stack): print(0)
        else: print(1)
    elif command == "top":
        if len(stack): print(stack[-1])
        else: print(-1)