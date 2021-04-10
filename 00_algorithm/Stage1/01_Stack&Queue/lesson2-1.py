# python 스택 deque

from collections import deque

s = deque()

s.append(1)
s.append(5)
s.append(10)
print("my stack is : ", s)
print("popped value is :", s.pop())
print("my stack is : ", s)
print("picked value is :", s[-1])
print("my stack is : ", s)