#Dinamic Programming을 활용

import sys
N = int(sys.stdin.readline())

dp = [x for x in range (N+1)] #최대갯수로 초기화
for i in range(2,N+1): 
    for j in range(1,i):
        if (j**2)>i:
            break

        if dp[i]>dp[i-j**2]+1: #새로 구한 값이 더 작으면 바꿔줌
            dp[i]=dp[i-j**2]+1


print(dp[N])
