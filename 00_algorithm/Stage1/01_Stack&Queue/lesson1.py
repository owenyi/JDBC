# python 스택 직접 구현

class Stack(list):

    push = list.append

    def peek(self):
        return self[-1]


s = Stack()
s.push(1)
s.push(5)
s.push(10)
print("my stack is : ", s)
print("popped value is :", s.pop())
print("my stack is : ", s)
print("peeked value is :", s.peek())
print("my stack is : ", s)