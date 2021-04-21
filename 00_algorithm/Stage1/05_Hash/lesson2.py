# class type dict

# 초기화
hash = dict()
print(hash)
hash = {}
print(hash)

# 값 추가
hash[1] = "apple"
hash["banana"] = 3
hash[(4, 5)] = [1, 2, 3]
hash[10] = {1: "a", 2: "b"}
# hash[[1, 2, 3]] = 5 # list 키로 사용 불가
# hash[{1, 2, 3}] = "orange" # set 키로 사용 불가
print(hash)

# 값 수정
hash["banana"] = 10
print(hash)

# 갑 추출
print(hash.pop(1))
print(hash)
print(hash.pop("banana"))
print(hash)

# 값 삭제
del hash[(4, 5)] # del 키워드
# print(del hash[(4, 5)]) # 안 됨
print(hash)

hash = dict() # 각각의 key 값의 제곱을 value로 갖는 dict
for i in range(1, 6):
    hash[i] = i**2

# loop
print(hash.keys())
for k in hash.keys():
    print(k)
print(hash.values())
for v in hash.values():
    print(v)
print(hash.items())
for k, v in hash.items():
    print(k, v)