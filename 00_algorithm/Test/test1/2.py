class Solution:
    def solution(self, s):
        s = list(s)  # 삽입을 위해 list로 캐스팅
        i = 0  # s에서 삽입할 문자를 선택할 인덱스
        n = len(s)  # 삽입할 위치는 고정
        while True:
            if self.isPelindrome(s): break
            s.insert(n, s[i])
            i += 1
        return len(s)

    def isPelindrome(self, s):  # 팰린드롬인지 여부를 반환
        N = len(s)
        for i in range(N // 2):  # 중간으로 좁혀가며 앞뒤를 비교한다
            if s[i] != s[N - 1 - i]:  # 다른 경우가 존재하면
                return False
        return True  # 끝까지 검사했는데 다른 경우가 없으면