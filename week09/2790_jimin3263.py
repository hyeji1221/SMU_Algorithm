#같은 색 보석만 가질 수 있음
#가장 많이 가진 보석의 수가 최소가 되도록
import sys
input = sys.stdin.readline

n,m = map(int,input().split())

jewelry=[]

for i in range(m):
    jewelry.append(int(input()))

#시작 = 1, 질투심 = mid
start, end=1, max(jewelry)

while start <= end:
    mid = (start+end) // 2 #한 명당 가져가는 보석 수
    sum = 0 #보석을 가져간 사람
    for jew in jewelry:
        if jew % mid == 0:
            sum += jew // mid
        else:
            sum += (jew//mid) + 1 #한 명이 나머지를 다 가져감

    if sum <= n: #n명 이하 = 조건 충족 -> 더 잘게 나눠서 한 명이 가져가는 보석 수를 줄여봄
        end = mid-1
    else:
        start = mid+1 #n명보다 많은 사람이 보석 가져감 -> 한 명이 가져가는 보석 수 늘림

print(start)
