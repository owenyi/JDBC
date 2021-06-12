list = [[1, 2],
        [3, 4],
        [2, 1],
        [4, 5],
        [6, 7],
        [4, 3],
        [6, 8]]

list.sort(key=lambda x:(x[0], x[1]))
print(list)