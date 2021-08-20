import sys
n=int(sys.stdin.readline())
board=[]
for i in range(n):
    board.append(list(map(int, sys.stdin.readline().split())))
    
dp=[[0]*n for _ in range(n)] #경로 체크
dp[0][0]=1 #시작점
cur=0 

for i in range(n):
    for j in range(n):
        if i==n-1 and j==n-1: #끝에 도착
            break
        
        cur=board[i][j]
        if j+cur<n: #오른쪽 이동
            dp[i][j+cur]+=dp[i][j]
        if i+cur<n: #아래쪽 이동
            dp[i+cur][j]+=dp[i][j]
            
print(dp[n-1][n-1])
