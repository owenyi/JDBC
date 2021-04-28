# 전화번호 목록

def solution(phone_book):
    phone_book.sort()
    for i in range(1, len(phone_book)):
        if phone_book[i - 1] == phone_book[i][:len(phone_book[i - 1])]:
            return False
    return True

phone_book = ["119", "21", "97674223", "1195524421"]
print(solution(phone_book))