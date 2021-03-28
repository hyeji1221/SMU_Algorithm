import sys
input = sys.stdin.readline

def rotate(start, val_cnt):
    r = R%val_cnt
    #박스에서 r만큼 회전
    for k in range(r):
        Val_start = arr[start][start]
        i, j = start, start
        
        l=0
        while (l<4):
            move_i = i + i_list[l]
            move_j = j + j_list[l]
            
            # 이동할 숫자 범위 정해줌 
            if (start <= move_i and move_i<N-start and start<=move_j and move_j<M-start):
                arr[i][j]= arr[move_i][move_j]
                i,j = move_i, move_j
            # 범위에 해당하지 않으면 박스 4구역 중, 다른 구역 이동
            else:
                l+=1
        # 마지막 빈자리에 넣음
        arr[start+1][start] = Val_start


N,M,R = map(int,input().split())
arr =[list(input().split()) for _ in range(N)]

# 우, 하, 좌, 상
i_list = [0,1,0,-1]
j_list = [1,0,-1,0]
n,m = N,M

for i in range(min(N,M)//2):
    # n*2+m*2-4 = 이동할 원소 개수
    # 모서리가 중복되기때문에 4빼줌
    rotate(i,n*2+m*2-4)
    n-=2
    m-=2

for i in arr:
    print(*i)
