# 이중우선순위큐 - heapq

import heapq

def solution(operations):
    q = []
    for o in operations:
        if o[0] == 'I': heapq.heappush(q, int(o[2:]))
        else:
            if not q: continue
            if o[2] == '1': q.remove(heapq.nlargest(1, q)[0])
            else: heapq.heappop(q)
    if not q: return [0, 0]
    return heapq.nlargest(1, q) + [q[0]]

print(solution(["I 16","D 1"]))
print(solution(["I 7","I 5","I -5","D -1"]))
print(solution(["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]))
print(solution(	["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]))