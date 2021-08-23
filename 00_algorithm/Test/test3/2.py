#핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
from collections import Counter

class Solution:
    def solution(self, statements):
        counter = Counter(statements)
        for key, value in list(counter.items())[::-1]:
            if key == value: return key
        if counter[0]: return -1
        else: return 0

s = Solution()
print(s.solution([1, 2, 3]))