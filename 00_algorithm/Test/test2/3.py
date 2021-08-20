#핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
from heapq import heappush, heappop

class Solution:
    def solution(self, candles):
        q = []
        for x in candles: heappush(q, -x)
        i = 1
        while q: # pq에서 꺼내서 초의 길이를 1씩 줄이고 집어넣고를 반복함
            temp = []
            for _ in range(i): # 꺼내서 1씩 줄여서 temp에 넣어 놓고
                if not q: return i - 1 # 뽑다가 비어버리면 함수 종료
                temp.append(heappop(q) + 1)
            for x in temp: # 0이면 버리고 아니면 다시 집어넣음
                if x == 0: continue
                heappush(q, x)
            i += 1
        return i - 1

candles = [5, 2, 2, 1]
s = Solution()
print(s.solution(candles))