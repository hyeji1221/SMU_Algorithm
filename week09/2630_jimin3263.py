import sys
input = sys.stdin.readline

#분할 정복 문제
n = int(input())
arr =[list(map(int,input().split())) for _ in range(n)]

white, blue = 0,0
def divide(y,x,n):
    global white,blue
    check = arr[y][x]
    for i in range(y,y+n):
        for j in range(x, x+n):
            if arr[i][j] != check:
                divide(y, x, n // 2) #2사분면
                divide(y, x + n // 2, n // 2) #1사분면
                divide(y + n//2, x, n // 2) #3사분면
                divide(y + n // 2, x + n // 2, n // 2) #4사분면
                return
    if check == 0:
        white += 1
    else:
        blue += 1

divide(0,0,n)
print(white, blue, sep="\n")
