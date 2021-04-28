# 완주하지 못한 선수

def solution(participant, completion):
    hash = dict()

    for i in range(len(completion)):
        name = completion[i]
        if hash.get(name): hash[name] += 1
        else: hash[name] = 1
    for i in range(len(participant)):
        name = participant[i]
        if hash.get(name): hash[name] -= 1
        else: return name