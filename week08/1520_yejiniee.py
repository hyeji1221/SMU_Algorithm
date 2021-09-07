import sys
m,n=map(int, sys.stdin.readline().split()) # (m x n)
board=[] #지도판
for _ in range(m):
    board.append(list(map(int, sys.stdin.readline().split())))

visited=[[-1]*n for _ in range(m)] #방문확인

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def dfs(x, y):
    if x==m-1 and y==n-1: #오른쪽 끝에 도달하면 종료
        return 1
    if visited[x][y]!=-1:
        return visited[x][y]
    visited[x][y]=0
    for i in range(4):
        nx=x+dx[i] # x이동
        ny=y+dy[i] # y이동
        if 0 <= nx < m and 0 <= ny < n: 
            if board[nx][ny] < board[x][y]: #낮은 곳으로만 이동
                visited[x][y] += dfs(nx, ny)
    return visited[x][y]

print(dfs(0,0))
