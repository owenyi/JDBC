# 구명보트

def solution(people, limit):
    people.sort()
    i, j = 0, len(people) - 1
    answer = 0
    while i <= j:
        if people[i] + people[j] > limit:
            j -= 1
            answer += 1
        else:
            i += 1
            j -= 1
            answer += 1
    return answer