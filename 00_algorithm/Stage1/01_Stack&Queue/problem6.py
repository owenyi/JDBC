# 크레인 인형뽑기 게임

def solution(board, moves):
    N = len(board)
    stack_list = [[] for _ in range(N)]
    for row in board[::-1]:
        for i, x in enumerate(row):
            if x > 0: stack_list[i].append(x)
    # print(stack_list)
    basket = []
    cnt = 0
    for x in moves:
        if stack_list[x - 1]:
            if basket and stack_list[x - 1][-1] == basket[-1]:
                del stack_list[x - 1][-1]
                del basket[-1]
                cnt += 2
            else: basket.append(stack_list[x - 1].pop())
    return cnt

print(solution([[0, 0, 0, 0, 0],
                [0, 0, 1, 0, 3],
                [0, 2, 5, 0, 1],
                [4, 2, 4, 4, 2],
                [3, 5, 1, 3, 1]], [1, 5, 3, 5, 1, 2, 1, 4]))