# python 구현된 클래스 import

from collections import deque

q = deque()
q.append(1)
q.append(5)
q.append(10)
print("my queue is :", q)
print("removed value is :", q.popleft())
print("my queue is :", q)
print("picked value is :", q[0]) # 메소드 없음
print("my queue is :", q)