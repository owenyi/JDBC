dict = {"a" : 1, "b":2}
print(dict)

print("\ndictionary(mutable) : immutable key + mutable value")
a = {1: 5, 2: 3} # int key
print(a)
a = {(1,5): 5, (3,3): 3} # tuple
print(a)
a = { 3.6: 5, "abc": 3} # float
print(a)
a = { True: 5, "abc": 3} # bool
print(a)

# mutable key...error
# a = { {1, 3}: 5, {3,5}: 3} # set
# a = {[1,3]: 5, [3,5]: 3} #list
# a = { {"a":1}: 5, "abc": 3} #dict

print("\nkey-value 추가")
a = {'x': 1, 'y': 2}
print(a)
a['z'] = 3
print(a)

print("\nkey 중복 불가능, 마지막 값으로 덮어 씀")
a = {'x': 1, 'y': 2}
print(a)
a['x'] = 3
print(a)

print("\n순서가 없기 때문에 인덱스가 아닌 키로 접근")
a = {"name": "Owen", "age": 27}
print("name :", a["name"])

# 출처 : https://wikidocs.net/16043