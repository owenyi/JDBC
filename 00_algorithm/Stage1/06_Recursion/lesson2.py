# 가능한 두 수의 합-재귀함수

data = [3, 5, 8] # 재귀함수의 경우 배열의 길이가 길어져도 함수 수정 없이 문제를 해결할 수 있음
result = set()
def recur(index, value):
    if index == len(data):
        result.add(value)
    else:
        recur(index + 1, value + data[index])
        recur(index + 1, value)
recur(0, 0)
print(result)
print(len(result))

# cf) 재귀함수 깊이 default 1000을 변경하는 방법
# import sys
# sys.setrecursionlimit(2500)