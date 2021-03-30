# 완전탐색 - 반복문

def solution(trump):
    for i in range(len(trump)):
        if trump[i] == 8:
            return i
    return -1