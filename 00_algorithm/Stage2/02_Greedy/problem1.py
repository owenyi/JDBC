# 2886 자리전쟁

import math
import heapq

R, C = map(int, input().split())

x_list = []
l_list = []
for r in range(R):
    row = input()
    for c in range(C):
        if row[c] == 'L': l_list.append((r, c))
        elif row[c] == 'X': x_list.append((r, c))

l_len, x_len = len(l_list), len(x_list)
isL = [False] * l_len
isX = [False] * x_len
q = []
for li, (lr, lc) in enumerate(l_list):
    d_list = []
    for xi, (xr, xc) in enumerate(x_list):
        d = math.sqrt((lr - xr) ** 2 + (lc - xc) ** 2)
        heapq.heappush(q, (d, li, xi))

cnt, l_cnt, x_cnt = 0, 0, 0
d, li, xi = heapq.heappop(q)
while q:
    nd, nli, nxi = heapq.heappop(q)
    if l_cnt == l_len or x_cnt == x_len: break
    if isL[nli] or isX[nxi]:
        isL[li] = True
        isX[xi] = True
        # 다다음부터 보는 코드
        # 좌석과 사람 모두 끝나지 않은 값을 찾을 때까지 반복해서 다음으로 넘어가는 게 중요하다
        while q:
            d, li, xi = heapq.heappop(q)
            if not (isL[li] or isX[xi]): break
        continue
    if d != nd:
        isL[li] = True
        isX[xi] = True
        l_cnt += 1
        x_cnt += 1
        d, li, xi = nd, nli, nxi
    else:
        if li == nli:
            isL[li] = True
            isX[xi] = True
            # isL[nxi] = True # 위와 동일함
            isX[nxi] = True
            l_cnt += 1
            x_cnt += 2
            while q:
                d, li, xi = heapq.heappop(q)
                if not (isL[li] or isX[xi]): break
            cnt += 1
        else:
            isL[li] = True
            isX[xi] = True
            l_cnt += 1
            x_cnt += 1
            d, li, xi = nd, nli, nxi
print(cnt)