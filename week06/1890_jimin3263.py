#1890
#오른쪽 or 아래로만 이동 가능
import sys
input = sys.stdin.readline

def dp(y,x):
    if y == n-1 and x == n-1: #오른쪽 아래 도착
        return 1
    if dp_arr[y][x] != -1: #-1이 아니라면 이미 이동했으니까 반환
        return dp_arr[y][x]
    dp_arr[y][x] = 0 #이동 완료
    #오른쪽으로 이동 -> +x, 아래로만 이동 -> +y
    nx = arr[y][x] + x
    ny = arr[y][x] + y
    if 0 <= nx and nx < n :
        dp_arr[y][x] += dp(y,nx)
    if 0<= ny and ny < n :
        dp_arr[y][x] += dp(ny,x)
    return dp_arr[y][x]

n = int(input())
arr =[list(map(int,input().split())) for _ in range(n)]
dp_arr = [[-1] * n for _ in range(n)] #dp 저장
print(dp(0, 0))
