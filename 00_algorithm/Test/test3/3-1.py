# 시간초과
class Solution:
    def solution(self, width, length):
        D = [(+1, 0), (0, -1), (-1, 0), (0, +1)]
        visited = [[False] * width for _ in range(length)]
        c, r = 0, length - 1
        chk = 0
        dc, dr = D[chk]
        depth = 1
        while True:
            while True:
                visited[r][c] = True
                nc, nr = c + dc, r + dr
                if -1 < nc < width and -1 < nr < length and not visited[nr][nc]:
                    c, r = nc, nr
                    depth += 1
                else: break
            if depth == width * length: return [c, length - r - 1]
            chk = (chk + 1) % 4
            dc, dr = D[chk]

s = Solution()
for i in range(1, 10):
    print(s.solution(i, 5))