# 다리를 지나는 트럭

def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge_weights = []
    while len(truck_weights) > 0:
        if len(bridge_weights) != 0 and bridge_weights[0][1] >= bridge_length:
            bridge_weights.pop(0)
        if sum([x[0] for x in bridge_weights]) + truck_weights[0] <= weight:
            bridge_weights.append([truck_weights.pop(0), 0])
        for x in bridge_weights: x[1] += 1
        answer += 1
    return answer + bridge_length

print(solution(2, 10, [7, 4, 5, 6]))
print(solution(100, 100, [10]))
print(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]))