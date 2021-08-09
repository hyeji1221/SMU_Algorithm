#1. 상하좌우 이동, 최소 이동 -> BFS
#1-1. 아기 상어는 자신보다 큰 물고기가 있는 칸은 지나갈 수 없음 => 크기가 작거나 같으면 이동 가능
#2. 작을 때만 먹을 수 있음
#2-1. 크기 증가 -> 크기 2: 2마리 먹어야 증가

from heapq import heappop, heappush
import sys
input = sys.stdin.readline

#입력
n = int(input())
arr =[list(map(int,input().split())) for _ in range(n)]
q =[]
#상하좌우만 이동
dy_dx_list = [(-1,0),(1,0),(0,-1),(0,1)]


def bfs(q):
    visited = [[False] * n for _ in range(n)]  # 방문 여부
    eat, size, result=0, 2, 0

    while(q):
        time, y, x = heappop(q)

        #작을때만 먹을 수 있음
        if (0 < arr[y][x] < size):
            #print("--냠-- ", arr[y][x])
            eat +=1
            arr[y][x] = 0
            #크기 증가 -> 크기 2: 2마리 먹어야 증가
            if(eat == size):
                size+=1
                eat =0

            result += time

            #먹음 -> 초기화
            visited = [[False] * n for _ in range(n)]
            time = 0
            q=[]

        for dy,dx in dy_dx_list:
            next_x, next_y = x + dx, y + dy
            #배열 벗어나지 말아야 함, 방문하지 않은 곳, 물고기 크기가 작거나 같을 때 방문 가능
            if (0 <= next_x <= (n - 1) and 0 <= next_y<= (n - 1) and arr[next_y][next_x] <= size and not visited[next_y][next_x]):
                visited[next_y][next_x] = True #방문 확인
                heappush(q,(time+1,next_y,next_x))

    return result


#아기상어 위치 반환
for i in range(n):
    for j in range(n):
        if (arr[i][j] == 9):
            heappush(q,(0,i,j))
            arr[i][j] = 0
            break

print(bfs(q))
