import sys
n=int(sys.stdin.readline())

#행이든 열이든 한 줄에 하나만 놓을 수 있음
row=[0]*n #퀸 위치표시
cnt=0 
visited=[False]*n #방문체크
         
def check(x):
    for i in range(x):
        if abs(row[x]-row[i]) == x-i: #대각선방향으로 겹치면
            return False
    return True
        
def dfs(x):
    global cnt
    if x == n:
        cnt += 1
    else:
        for i in range(n):
            if visited[i]:
                continue
            row[x] = i
            if check(x): #대각선방향으로 겹치지 않으면
                visited[i]=True
                dfs(x+1)
                visited[i]=False

dfs(0)
print(cnt)
