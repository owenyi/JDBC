# 괄호변환

def solution(p):
    if p == "": return ""
    start = p[0]
    stack = 1
    i = 1
    while True:
        if p[i] == start:
            stack += 1
        else:
            stack -= 1
        i += 1
        if stack == 0: break
    u, v = p[:i], p[i:]
    if start == '(':
        return u + solution(v)
    else:
        return '(' + solution(v) + ')' + ''.join(['(' if x == ')' else ')' for x in u[1:-1]])

print(solution("(()())()"))

u = "(())()"
print(''.join(['(' if x == ')' else ')' for x in u]))