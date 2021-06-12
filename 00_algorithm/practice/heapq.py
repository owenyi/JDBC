import heapq

a = [4, 2, 3, 1]

print("===push===")
q = []
for x in a:
    heapq.heappush(q, x)
    print(q)

print("===pop===")
while q:
    print(q)
    heapq.heappop(q)

print("===heapify===")
q = [4, 2, 3, 1]
heapq.heapify(q)
print(q)

print("===max heap===")
q = [4, 2, 3, 1]
q = list(map(lambda x: (-x, x), q))
heapq.heapify(q)
print(q)