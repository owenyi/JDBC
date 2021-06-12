# 이중우선순위큐

import heapq

def solution(operations):
    q = []
    for o in operations:
        if o[0] == 'I': heapq.heappush(q, int(o[2:]))
        else:
            if not q: continue
            if o[2] == '1': del q[heap_max(q)]
            else: heapq.heappop(q)
    if not q: return [0, 0]
    return [q[heap_max(q)], q[0]]

def heap_max(q):
    i = 1
    n = len(q) + 1
    while True:
        if i * 2 >= n: break
        i *= 2
        if i + 1 < n and q[i - 1] < q[(i - 1) + 1]: i += 1
    return i - 1

print(solution(["I 16","D 1"]))
print(solution(["I 7","I 5","I -5","D -1"]))
print(solution(["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]))
print(solution(	["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]))