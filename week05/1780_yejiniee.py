import sys
n=int(sys.stdin.readline())
board=[]
count=[0, 0, 0] #-1 0 1을 카운트

for i in range(n):
    board.append(list(map(int, sys.stdin.readline().split())))
    
def cut(x,y,n):
    num_check=board[x][y]
    for i in range(x,x+n): 
        for j in range(y,y+n):
            if num_check!=board[i][j]: #같은 숫자가 아니면 9등분
                cut(x,y,n//3)
                cut(x, y+n//3, n//3)
                cut(x, y+2*(n//3), n//3)
                
                cut(x+n//3, y, n//3)
                cut(x+n//3, y+n//3, n//3)
                cut(x+n//3, y+2*(n//3), n//3)

                cut(x+2*(n//3), y, n//3)
                cut(x+2*(n//3), y+n//3, n//3)
                cut(x+2*(n//3), y+2*(n//3), n//3)
                return


    #한 면이 전부 같은 숫자가 되면
    if num_check== -1:
        count[0]+=1
    elif num_check== 0:
        count[1]+=1
    else:
        count[2]+=1
                
cut(0,0,n)

print(count[0])
print(count[1])
print(count[2])
