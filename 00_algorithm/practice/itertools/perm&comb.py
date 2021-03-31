from itertools import permutations, combinations

a = [1, 2, 3]

perm = permutations(a, 2)
print(list(perm))
print("\n")

perm = permutations(a, 3)
print(list(perm))
print("\n")

perm = permutations(a) # default=3
print(list(perm))
print("\n")

comb = combinations(a, 2)
print(list(comb))
print("\n")

comb = combinations(a, 3)
print(list(comb))
print("\n")

comb = combinations(a) # error
print(list(comb))