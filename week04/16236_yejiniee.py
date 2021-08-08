#bfs를 이용

import sys, collections

shark_x=0 
shark_y=0
size=2 
eat_cnt=0 #먹은 물고기 개수
fish_cnt=0 #보드 안에 존재하는 물고기 개수
fish_pos=[] #물고기의 위치
time=0 
dx=(0,0,1,-1) 
dy=(1,-1,0,0)

input=sys.stdin.readline
n=int(input()) 
board=[list(map(int,input().split())) for _ in range(n)] 

#물고기의 위치와 개수, 상어의 위치 저장
for i in range(n):
    for j in range(n):
        if 0<board[i][j]<=6: #물고기가 존재하면
            fish_cnt+=1
            fish_pos.append((i,j))
        elif board[i][j]==9: #아기상어의 위치 저장
            shark_x=i
            shark_y=j
board[shark_x][shark_y]=0 #아기상어가 지나갈 수 있게 0으로 바꿈

#먹을 수 있는 물고기와의 거리를 구하는 함수
def bfs(shark_x,shark_y):
    dist_list=[] #거리를 저장하는 리스트
    q=collections.deque([(shark_x,shark_y,0)])
    visited=[[False]*n for _ in range(n)] 
    visited[shark_x][shark_y]= True 
    min_dist=int(1e9) #최단거리를 제일 큰 수로 초기화

    while q: #큐가 비기 전까지
        x,y,dist=q.popleft() 
        for i in range(4): #상하좌우 4번 체크
            xx = dx[i]+x
            yy = dy[i]+y 
            if 0<=xx<n and 0<=yy<n and not visited[xx][yy]: 
                if board[xx][yy] <= size: #상어보다 큰 물고기 존재하지 않으면
                    visited[xx][yy] = True #지나갈 수 있다
                    if 0<board[xx][yy]<size: #먹을 수 있는 물고기이면
                        min_dist = dist 
                        dist_list.append((dist+1,xx,yy)) #먹이와의 거리와 위치 저장
                    if dist+1 <= min_dist: #최단거리라면
                        q.append((xx,yy,dist+1)) #큐에 상어의 위치와 최단거리 추가

    if dist_list: #먹을 수 있는 물고기가 존재하면
        dist_list.sort() #가까운 순으로 정렬
        return dist_list[0] #제일 가까운 물고기와의 거리와 그 좌표 리턴
    else:
        return False


while fish_cnt: #먹을 수 있는 물고기가 없으면 종료
    result=bfs(shark_x, shark_y)
    if not result: #가까운 곳에 먹이가 없다면
        break #time이 0인 채로 끝남
    shark_x, shark_y=result[1], result[2] #물고기 먹으러 상어이동
    time+=result[0] 
    eat_cnt+=1 
    fish_cnt-=1 
    if size==eat_cnt: 
        size+=1 #상어 성장
        eat_cnt=0 
    board[shark_x][shark_y]=0 

print(time)
