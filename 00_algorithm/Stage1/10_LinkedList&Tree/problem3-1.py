# 이중우선순위큐 - leaf에서 max 찾기

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
    m, midx = q[-1], len(q) - 1
    end = (midx + 1) // 2 - 1
    for i in range(midx - 1, end, -1):
        if m < q[i]: m, midx = q[i], i
    return midx

print(solution(["I 16","D 1"]))
print(solution(["I 7","I 5","I -5","D -1"]))
print(solution(["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]))
print(solution(	["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]))