# 전화번호 목록 

# 한 번호가 다른 번호의 접두어인 경우가 있는지 확인
# ver 1 : 이중 포문
def solution(phone_book):
   answer = True
   
   phone_book.sort()
   for i in range(len(phone_book) - 1):
      for j in range(i + 1, len(phone_book)):
         if phone_book[i] == phone_book[j][:len(phone_book[i])]:                
               return False
   
   return True


# ver 2 : 포문 하나 
def solution(phone_book):
   answer = True
   
   phone_book.sort()
   for i in range(len(phone_book) - 1):
      if phone_book[i] == phone_book[i + 1][:len(phone_book[i])]:
         return False
   
   return True



