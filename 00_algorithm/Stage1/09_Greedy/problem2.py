# 10162 전자레인지

T = int(input())
answer = []
answer.append(T // 300)
T %= 300
answer.append(T // 60)
T %= 60
answer.append(T // 10)
T %= 10
if T: print(-1)
else:
    for x in answer: print(x, end=' ')