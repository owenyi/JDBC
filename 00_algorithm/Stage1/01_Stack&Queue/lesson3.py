# python 큐 직접 구현

class Queue(list):

    put = list.append

    def peek(self):
        return self[0]

    def get(self):
        return self.pop(0)


q = Queue()
q.put(1)
q.put(5)
q.put(10)
print("my queue is :", q)
print("removed value is :", q.get())
print("my queue is :", q)
print("peeked value is :", q.peek())
print("my queue is :", q)