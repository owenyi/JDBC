a = [[1, 2], [3, 4], [1, 9]]
print(max(a)) # default key=lambda x: x[1]
print(max(a, key=lambda x: x[1]))