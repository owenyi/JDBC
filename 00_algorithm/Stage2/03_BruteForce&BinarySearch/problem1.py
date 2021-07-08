# 징검다리

def solution(distance, rocks, n):
    rocks.append(0)
    rocks.append(distance)
    rocks.sort()
    low, top = 0, distance
    while low <= top:
        mid = (low + top) // 2
        i, j, end = 0, 1, len(rocks)
        cnt = 0
        while j < end - 1:
            if rocks[j] - rocks[i] < mid:
                cnt += 1
                j += 1
            else:
                i = j
                j += 1
        if cnt <= n: low = mid + 1
        else: top = mid - 1
    return top

print(solution(25, [2, 14, 11, 21, 17], 2))