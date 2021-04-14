# 비밀지도

def toBin(n, num):
    bin = ''
    for _ in range(n):
        bin += str(num % 2)
        num //= 2
    pwd = ''
    for x in bin[::-1]:
        if x == '1': pwd += '#'
        elif x == '0': pwd += ' '
    return pwd

def solution(n, arr1, arr2):
    answer = []
    for x, y in zip(arr1, arr2):
        answer.append(toBin(n, x | y))
    return answer