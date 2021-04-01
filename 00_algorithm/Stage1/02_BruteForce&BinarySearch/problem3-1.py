# 숫자카드
import sys
input = sys.stdin.readline # 그냥 input보다 빠름
from collections import Counter # 개수 dict

N = int(input())
cards = Counter(input().split())
M = int(input())
nums = input().split()
for x in nums:
    print(cards[x], end=' ')