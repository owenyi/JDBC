class Solution:
    def solution(self, X, Y, walkTime, sneakTime):
        if walkTime*2 <= sneakTime: # 직선으로 두 번 움직이는 게 대각선으로 한 번 움직이는 것보다 덜 걸릴 때
            answer = (X + Y) * walkTime # 그냥 walkTime으로 계산
        else: # 이 경우에는 sneakTime까지 고려해줘야 함
            _min = min(X, Y) # 대각선부터 계산
            answer = _min * sneakTime
            X -= _min
            Y -= _min
            if sneakTime*2 < walkTime*2: # 두 칸 이동하는 두 가지 방법을 비교
                answer += (X + Y) * sneakTime
                if (X + Y) % 2 == 1: # 남은 칸 수가 홀수라면
                    answer += walkTime - sneakTime
            else: answer += (X + Y) * walkTime
        return answer