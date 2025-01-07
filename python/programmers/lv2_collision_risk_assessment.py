# 충돌 위험 찾기 

# ver 1 : 틀림 -> 최단 경로 계산이 이상함??? 
def solution(points, routes):
   N = len(points)
   M = len(routes)
   answer = 0
   cntDict = {}
   for i in range(M):
      point = tuple(routes[i])
      if point not in cntDict:
         cntDict[point] = 1
      else:
         cntDict[point] += 1
   
   for k, v in cntDict.items():
      if v > 1:
         answer += 1

   # 1 <= r <= 100 / 1 <= c <= 100
   robot_routes = dict()
   for i in range(N):
      robot_routes[i+1] = []

   # X대 로봇, 4방향으로 이동 dr 방향 우선 
   def get_dir(sr, sc, er, ec):
      if sr >= er and sc >= ec:     # 시작점 중심 위    왼쪽 
         return [(-1, 0), (0, -1)]
      elif sr >= er and sc <= ec:   # 시작점 중심 위    오른쪽
         return [(-1, 0), (0, 1)]      
      elif sr <= er and sc >= ec:   # 시작점 중심 아래  왼쪽
         return [(1, 0), (0, -1)]       
      elif sr <= er and sc <= ec:   # 시작점 중심 아래  오른쪽
         return [(1, 0), (0, 1)]

   def get_points(robot, start, goal):
      sr, sc = start[0], start[1]
      nr, nc = sr, sc 
      er, ec = goal[0], goal[1]
      dir = get_dir(sr, sc, er, ec)
      K = abs(sr-er) + abs(sc-ec)
      tmp = 0
      while tmp < K:
         if nr == er and nc == ec:
            break

         if abs(nr-er) > 0:
            nr, nc = nr + dir[0][0], nc + dir[0][1]
         elif abs(nc-ec) > 0:
            nr, nc = nr + dir[1][0], nc + dir[1][1]
         
         robot_routes[robot].append((nr,nc))            
         tmp += 1

   for i in range(len(routes)):
      robot = i + 1
      for j in range(len(routes[i]) - 1):
         start, end = points[routes[i][j]-1], points[routes[i][j+1]-1]
         get_points(robot, start, end)

   # 마지막 포인트에 도착한 로봇은 삭제 
   # 같은 포인트에 로봇이 2대 이상 모이면 충돌
   #  -> 몇 번 일어나는지 횟수 구하기 

   # 배열 최고 길이 구하기 
   maxL = 0
   for i in range(len(robot_routes)):
      maxL = max(len(robot_routes[i+1]), maxL)
   
   for l in range(maxL):
      tmp = dict()
      for r in range(len(robot_routes)):
         if not robot_routes[r+1]: continue
         try:
            if robot_routes[r+1][l] not in tmp:
               tmp[robot_routes[r+1][l]] = 1
            else:
               tmp[robot_routes[r+1][l]] += 1

         except IndexError:
            pass

      for k, v in tmp.items():
         if v > 1:
            # 8이 나온 이유, 시작점인 1,4를 카운트 하지 않아서 
            answer+=1
            
   return answer



print(solution([[3, 2], [6, 4], [4, 7], [1, 4]], [[4, 2], [1, 3], [2, 4]]))
print(solution([[3, 2], [6, 4], [4, 7], [1, 4]], [[4, 2], [1, 3], [4, 2], [4, 3]]))
# solution([[2, 2], [2, 3], [2, 7], [6, 6], [5, 2]], [[2, 3, 4, 5], [1, 3, 4, 5]])



# ver 2 : deque로 최단 경로 리스트 구해보자!  




