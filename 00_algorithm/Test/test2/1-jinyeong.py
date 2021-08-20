class Solution:
    def solution(self, code, message):
        code = list(code)
        answer =''
        if message.isdigit():
            message = [int(message[i:i+2]) for i in range(0, len(message),2)]
            for i in message:
                answer += code[i-1]
        else:
            for i in message:
                answer += str(code.index(i)+1).rjust(2,'0')
        return answer