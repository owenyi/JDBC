# 완전탐색 - 재귀함수

def solution(trump, loc):
    if trump[loc] == 8:
        return loc
    else:
        return solution(trump, loc + 1)