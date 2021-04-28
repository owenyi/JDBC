# 완주하지 못한 선수

def solution(participant, completion):
    participant.sort()
    completion.sort()
    completion.append("z")
    for i in range(len(participant)):
        if participant[i] != completion[i]:
            return participant[i]