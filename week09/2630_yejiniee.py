import sys
input=sys.stdin.readline
n=int(input()) 
paper=[]
for _ in range(n): #nxn 종이
    paper.append(list(map(int, input().split())))

white=0 #0
blue=0 #1

def cut(x,y,n):
    global blue, white
    check=paper[x][y] 
    for i in range(x,x+n):
        for j in range(y,y+n):
            if check!=paper[i][j]: #다른 색이 하나라도 나오면, 4등분으로 나눔
                cut(x,y,n//2) 
                cut(x,y+n//2,n//2) 
                cut(x+n//2,y,n//2) 
                cut(x+n//2,y+n//2,n//2) 
                return

    if check==0: #전체 흰색일때
        white+=1
        return
    else: #전체 파란색일때
        blue+=1
        return

cut(0,0,n)
print(white)
print(blue)
