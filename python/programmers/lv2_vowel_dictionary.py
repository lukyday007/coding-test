'''
'A', 'E', 'I', 'O', 'U'
첫 번째 단어는 "A"이고, 그다음은 "AA", "AAA", "AAAA", "AAAAA", "AAAAE", ... 와 같습니다. "AAAAE"는 사전에서 6번째 단어
"AAAE"는 "A", "AA", "AAA", "AAAA", "AAAAA", "AAAAE", "AAAAI", "AAAAO", "AAAAU"의 다음인 10번째 단어

A AA AAA AAAA AAAAA 
              AAAAE AAAAI AAAAO AAAAU(9)
         AAAE(10) 
         AAAEA AAAEE AAAEI AAAEO AAAEU
         AAAI 
         AAAIA AAAIE AAAII AAAIO AAAIU
         AAAO 
         AAAOA AAAOE AAAOI AAAOO AAAOU
         AAAU
         AAAUA AAAUE AAAUI AAAUO AAAUU
     AAE AAI AAO AAU
  AE AI AO AU 
E 

'''

vowels = ["A", "E", "I", "O", "U"]
found = False
answer = 0

def dfs(res, word):
   global found, answer

   if res == word:
      found = True
      return

   if len(res) == 5:
      return

   for vowel in vowels:
      if found:  # 이미 단어를 찾았다면 탐색 중단
         return
      answer += 1
      dfs(res + vowel, word)

def solution(word):
   global answer
   dfs("", word)
   return answer

print(solution("I"))      



