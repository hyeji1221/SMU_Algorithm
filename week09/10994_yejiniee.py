import sys

def star_draw(n, idx):
    if n==1:
        star[idx][idx]='*'
        return ;
    l=4*n-3
    
    for i in range(idx, l+idx):
        #가로줄
        star[idx][i]='*' #위
        star[idx+l-1][i]='*' #아래
        #세로줄
        star[i][idx]='*' #왼쪽
        star[i][idx+l-1]='*' #오른쪽

    return star_draw(n-1, idx+2) #재귀함수
    
n=int(sys.stdin.readline())
lens=4*n-3 #*의 길이

star=[[' ']*lens for _ in range(lens)]

star_draw(n,0)

for i in range(lens): #별그림 그리기
    for j in range(lens):
        print(star[i][j], end="")
    print()
