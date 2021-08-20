#핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
class Solution:
    def solution(self, tri):
        for r in range(2, len(tri) + 1):
            tri[-r] = list(tri[-r]) # str은 item assignment 불가하므로 list로 잠시 바꿈
            for c in range(len(tri[-r])):
                if tri[-r][c].isnumeric():
                    start = c # 중간에 숫자가 존재하는 위치를 찾아서 양 옆으로 채원나갈 예정
                    break
            for c in range(start, 0, -1):
                if tri[-r][c-1] == '?':
                    tri[-r][c-1] = str((int(tri[-r+1][c-1]) - int(tri[-r][c])) % 10) # a+b=c -> a=c-b를 이용
            for c in range(start, len(tri[-r]) - 1):
                if tri[-r][c+1] == '?':
                    tri[-r][c+1] = str((int(tri[-r + 1][c]) - int(tri[-r][c])) % 10)
        for r in range(2, len(tri) + 1):
            tri[-r] = ''.join(tri[-r])
        return tri

s = Solution()
tri = ["??2?", "4??","?2","1"]
print(s.solution(tri))