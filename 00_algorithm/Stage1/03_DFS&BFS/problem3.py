# 타겟넘버

cnt = 0

multi = lambda x: x[0] * x[1]

def DFS(numbers, target, signs):
    if len(signs) == len(numbers):
        if sum(list(map(multi, zip(numbers, signs)))) == target:
            global cnt
            cnt += 1
    else:
        DFS(numbers, target, signs + [1])
        DFS(numbers, target, signs + [-1])

def solution(numbers, target):
    signs = []
    DFS(numbers, target, signs)
    answer = cnt
    return answer