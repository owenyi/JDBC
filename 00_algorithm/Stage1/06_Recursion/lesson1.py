# 가능한 두 수의 합-반복문

data = [3, 5, 8]
result = set()
for i in range(2):
    for j in range(2):
        for k in range(2):
            result.add(data[0] * i + data[1] * j + data[2] * k)
print(result)
print(len(result))