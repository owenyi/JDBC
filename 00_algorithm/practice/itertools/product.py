from itertools import product

a = [1, 2]
b = [3]

prod = product(a, b)
print(prod)
print(prod)
print(list(prod))
print(list(prod)) # 한 번 리스트에 담고 나면 사라짐
print("\n")

prod = product(a, b, repeat=2) # product 결과를 다시 product
print(list(prod))
print(len(list(prod)))

