# 비트연산

print('a', 'b', '&', '|', '^')
print(0, 0, 0 & 0, 0 | 0, 0 ^ 0)
print(0, 1, 0 & 1, 0 | 1, 0 ^ 1)
print(1, 0, 1 & 0, 1 | 0, 1 ^ 0)
print(1, 1, 1 & 1, 1 | 1, 1 ^ 1)
print()

print(bin(~0b0000)) # -0001 = 1111
print(bin(~0b0001)) # -0010 = 1110
print(bin(~0b0101)) # -0110 = 1010
print(bin(~0b0111)) #
print()

print(bin(0b11<<1)) # 110
print(bin(0b1100<<2)) # 110000
print(bin(0b11>>1)) # 1
print(bin(0b1100>>2)) # 11
print()

print(bin(35))
print(bin(5))
print(int(0b100111))
print(35|5)