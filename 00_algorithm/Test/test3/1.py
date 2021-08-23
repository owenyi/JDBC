#핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
class Solution:
    def solution(self, numbers):
        numbers.sort()
        N = len(numbers)
        _max, _min = numbers[-1], numbers[0]
        if N != len(set(numbers)): return []
        if _max - _min + 1 == N:
            answer = [_max + 1]
            if _min - 1 > 0: answer.insert(0, _min - 1)
            return answer
        if _max - _min + 1 == N + 1:
            for i, x in enumerate(numbers):
                if x - _min != i:
                    return [i + _min]
        return []

s = Solution()
print(s.solution([9, 9]))