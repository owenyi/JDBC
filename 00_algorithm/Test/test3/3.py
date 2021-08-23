#핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
class Solution:
    def solution(self, width, length):
        if width >= length:
            if length % 2 == 1:
                y = length // 2
                x = width - 1 - y
            else:
                y = length // 2
                x = y - 1
        elif width < length:
            if width % 2 == 1:
                x = width // 2
                y = length - 1 - x
            else:
                y = width // 2
                x = y - 1
        return [x, y]

s = Solution()
for i in range(1, 10):
    print(s.solution(i, 5))