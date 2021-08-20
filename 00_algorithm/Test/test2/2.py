#핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
class Solution:
    def solution(self, instructions):
        answer = 0
        for x in instructions:
            if x == "HALT": break
            if x == "LEFT": answer -= 90
            elif x == "RIGHT": answer += 90
            elif x == "TURN AROUND": answer += 180
            else: # LEFT, RIGHT 값 지정
                cmd, angle = x.split()
                if cmd == "LEFT": answer -= int(angle)
                elif cmd == "RIGHT": answer += int(angle)
        return answer % 360

instructions = ["LEFT 5","RIGHT 10","LEFT 15","RIGHT 20","LEFT 25","RIGHT 30","LEFT 35"]
s = Solution()
print(s.solution(instructions))