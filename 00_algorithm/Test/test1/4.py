class Solution:
    def solution(self, price, cost):
        selling = sorted(list(set(price)))  # 최적가 리스트, 2가지 이상인 경우 더 작은 값을 리턴하기 위해 정렬
        answer = 0
        _max = 0
        for x in selling:
            prof = 0  # 이익의 합을 담을 변수
            for i in range(len(price)):
                prof += self.profit(x, price[i], cost[i])
            if prof > _max:
                _max = prof  # 최대값 갱신시마다
                answer = x  # 정답 갱신
        return answer

    def profit(self, x, p, c):
        if p < x:  # 지불할 수 있는 최대 금액이 판매가보다 적다면
            prof = 0  # 못 삼
        else:  # 살 수 있으면
            if x - c < 0:  # 배송비 때문에 이익이 마이너스면
                prof = 0
            else:
                prof = x - c  # 판매가 - 배송비
        return prof
