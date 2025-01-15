# 가사 검색 - 2020 kakao blind recruitment
# ver 1 - ?을 없애기 위한 이분탐색 
def solution(words, queries):
   answer = []
   words.sort()
   # 효율성 체크 -> 검색 키워드 중복 가능성? => 2시간초과 3실패
   doubleCheck = dict()

   # 단어길이 별 딕셔너리 생성
   wordLength = dict()
   for word in words:
      if len(word) not in wordLength:
         wordLength[len(word)] = [word]
      wordLength[len(word)].append(word)
   
   for query in queries:
      if query in doubleCheck:
         answer.append(doubleCheck[query])
         continue
      
      if len(query) not in wordLength:  # 길이에 맞는 단어가 없는 경우
         doubleCheck[query] = 0
         answer.append(0)
         continue
      
      # print(f"query: { query}")
      res = 0        
      flag = False     # 접두"?--" -> True, 접미"--?" -> False
      if query[0] != '?':
         flag = True 
      
      staIdx, endIdx = 0, len(query) 
      sta, end = 0, len(query) - 1
      while sta <= end:
         mid = (sta + end) // 2
         
         if flag: # 접두"?--"
               if query[mid-1] != '?' and query[mid] == '?':           
                  endIdx = mid 
                  # print(f"endIdx : {endIdx}, mid : {mid}")
                  break
               elif query[mid] == '?':
                  end = mid - 1
               else:
                  sta = mid + 1
         else:   # 접미"--?"
               if query[mid-1] == '?' and query[mid] != "?":
                  staIdx = mid
                  # print(f"staIdx : {staIdx}, mid : {mid}")
                  break
               elif query[mid] == '?':
                  sta = mid + 1
               else:
                  end = mid - 1
                  
      # print(f"query[{staIdx}:{endIdx}]: {query[staIdx:endIdx]}")
      for word in words:    
         # print(f"word: {word}")
         # query와 word의 길이가 맞지 않으면 0 반환
         if len(query) != len(word):
               continue
         if query[staIdx:endIdx] == word[staIdx:endIdx]:
               res += 1
      # print()              
      answer.append(res)
      doubleCheck[query] = res
   
   return answer

# ver2 - 임의의 단어 생성 froaa - frozz 해서 이분탐색으로 해당 범위 인덱스 조회 
def find_words(arr, staVal, endVal):
   sta = find_point(arr, staVal, True)
   end = find_point(arr, endVal, False)
   
   return end - sta
    
def find_point(arr, target, status):
   sta, end = 0, len(arr)
   while sta < end:
      mid = (sta + end) // 2
      if status:
         if arr[mid] < target:
               sta = mid + 1
         else:
               end = mid 
      else:
         if arr[mid] <= target:
               sta = mid + 1
         else:
               end = mid 
   
   return sta

def solution(words, queries):
   answer = []
   
   # 단어 하나당 최대 길이 10000
   wordArr = [[] for _ in range(10001)]    # 접두사용
   revArr = [[] for _ in range(10001)]     # 접미사용 
   
   for word in words:
      wordArr[len(word)].append(word)
      revArr[len(word)].append(word[::-1])
   
   for i in range(1, 10001):
      wordArr[i].sort()
      revArr[i].sort()
      
   for query in queries:
      res = 0
      if query[0] != '?':     # 접두사 
         res = find_words(wordArr[len(query)], query.replace('?', 'a'), query.replace('?', 'z'))
      else:
         res = find_words(revArr[len(query)], query[::-1].replace('?', 'a'), query[::-1].replace('?', 'z'))
         
      answer.append(res)
                  
   return answer 