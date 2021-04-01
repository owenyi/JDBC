# 숫자카드2 - 실패, 시간초과

N = int(input())
cards = input().split()
M = int(input())
nums = input().split()
for x in nums:
    print(cards.count(x), end=' ')
# nums = map(lambda x: print(cards.count(x), end=' '), input().split())
# for x in nums:
#     x