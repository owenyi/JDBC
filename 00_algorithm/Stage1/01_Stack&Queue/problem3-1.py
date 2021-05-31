# 다리를 지나는 트럭

def solution(bridge_length, weight, truck_weights):
    bridge_trucks = []
    answer = 0
    i = 0
    while True:
        if i == len(truck_weights): break
        if sum(bridge_trucks) + truck_weights[i] > weight:
            bridge_trucks.append(0)
        else:
            bridge_trucks.append(truck_weights[i])
            i += 1
        if len(bridge_trucks) == bridge_length: del bridge_trucks[0]
        answer += 1
    return answer + bridge_length

print(solution(2, 10, [7, 4, 5, 6]))
print(solution(100, 100, [10]))
print(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]))