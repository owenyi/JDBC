def plusTwo(x):
    return x + 2

nums = [1, 2, 3]
for i in range(len(nums)):
    nums[i] = plusTwo(nums[i])
print(nums)

nums2 = [1, 2, 3]
nums2 = list(map(plusTwo, nums2))
print(nums2)

print()
from itertools import permutations

numStr = "123"
perm = permutations(numStr, 2)
perm = list(map(''.join, perm))
print(perm)