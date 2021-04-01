# 10828 스택

import sys
input = sys.stdin.readline

stack = []

def operation(command, num=0):
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

N = int(input())
for i in range(N):
    line = input().split()
    if len(line) == 1: operation(line[0])
    elif len(line) == 2: operation(line[0], line[1])
