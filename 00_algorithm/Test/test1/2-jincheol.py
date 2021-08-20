class Solution:
    def solution(self, s):
        if s==s[::-1]: return len(s)
        for i in range(len(s)):
            if s[i:]==s[i:][::-1]:
                return len(s) + i