class Solution:
    def numeric(self, code, message):
        answer = ''
        for i in range(0, len(message), 2):
            answer += code[int(message[i:i + 2]) - 1]
        return answer

    def lower(self, code_dict, message):
        answer = ''
        for x in message:
            answer += code_dict[x]
        return answer

    def solution(self, code, message):
        code_dict = {}
        for i, x in enumerate(code):
            code_dict[x] = '0' + str(i + 1) if i < 9 else str(i + 1)
        if message.isnumeric(): return self.numeric(code, message)
        else: return self.lower(code_dict, message)

code = "abcdefghijklmnopqrstuvwxyz"
message1 = "20051920"
message2 = "test"
s = Solution()
print(s.solution(code, message1))
print(s.solution(code, message2))