# python 구현된 클래스 import

from queue import Queue

q = Queue()
q.put(1)
q.put(5)
q.put(10)
print("my queue is :", q)
print("removed value is :", q.get())
print("my queue is :", q)
# print("peeked value is :", q.peek()) # 메소드 없음
# print("my queue is :", q)