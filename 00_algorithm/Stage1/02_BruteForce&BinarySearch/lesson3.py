# 이분탐색 : 이진검색이라고도 하며 오름차순으로 정렬된 리스트에서 특정 값의 위치를 찾는 알고리즘

def solution(trump):
    left = 0
    right = len(trump) - 1
    while (left <= right):
        mid = (left + right) / 2
        if trump[mid] == 8:
            return mid
        elif trump[mid] < 8:
            left = mid + 1
        elif trump[mid] > 8:
            right = mid - 1
    return mid