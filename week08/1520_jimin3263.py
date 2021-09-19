#1520
#이웃한 곳만 이동 가능 -> 항상 내리막길, 모든 경로 탐색 -> dfs, dp
import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

#북,동,남,서
dy=[-1,0,1,0]
dx=[0,1,0,-1]

def dfs(y, x):
    if y == m-1 and x == n-1: #최종 목적지 도착
        return 1
    if arr2[y][x] != -1: #-1이 아니라면 이미 이동했으니까 반환
        return arr2[y][x]
    arr2[y][x] = 0 #이동한 곳은 표시해둠
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx and nx < n and 0 <= ny and ny < m:
            if arr[y][x] > arr[ny][nx]: # 더 낮아야 이동
                arr2[y][x] += dfs(ny, nx)
    return arr2[y][x]

m, n= map(int,input().split())
arr =[list(map(int,input().split())) for _ in range(m)] #지도 숫자 입력
arr2 = [[-1] * n for _ in range(m)] #dp 저장
print(dfs(0, 0))
