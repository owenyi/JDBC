class Solution:
    def solution(self, number, dictionary):
        dictionary.sort() # 알파벳 순서로 먼저 있는 것을 우선 고르기 위한 정렬
        answer = "" # 정답 문자열
        for x in number:
            for i, d in enumerate(dictionary):
                if len(d) == int(x): 
                    answer += dictionary.pop(i) + " " # 길이에 맞는 문자열 찾을 때마다 정답 문자열에 병합
                    break
        return answer[:-1]