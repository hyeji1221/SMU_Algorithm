import sys
import copy
input = sys.stdin.readline
def island(i,j):
    #상하좌우
    global left_i,left_j,right_i,right_j
    di = [-1,1,0,0]
    dj = [0,0,-1,1]

    count = 0
    if(arr[i][j] == 'X'):
        for k in range(4):
            go_i = i + di[k]
            go_j = j + dj[k]
            #인덱스 범위 벗어남, 즉 바다 부분
            if (go_i == -1 or go_i == R or go_j == -1 or go_j == C ):
                count+=1
            #바다인 경우 확인
            if ( 0<=go_i and go_i <R and 0<=go_j and go_j <C ):
                if(arr2[go_i][go_j]=='.'):
                    count+=1
        # 주변 바다 개수가 3,4 인 경우 섬-> 바다 
        if count > 2:
            arr[i][j] = "."
        # 왼쪽 위 -> 최소
        # 오른쪽 아래 -> 최대
        else:
            left_i = min(left_i,i)
            left_j = min(left_j,j)
            right_i = max(right_i,i)
            right_j = max(right_j,j)



R,C = map(int,input().split())
arr = [list(input().rstrip()) for _ in range(R)]
arr2 = copy.deepcopy(arr)

#바다 부분 생략하기 위한 변수
left_i = R
left_j = C
right_i = -1
right_j = -1

for i in range(R):
    for j in range(C):
        island(i,j)

for i in range(left_i,right_i+1):
    for j in range(left_j,right_j+1):
        print(arr[i][j],end='')
    print()
