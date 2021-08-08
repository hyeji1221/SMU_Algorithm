#1699
#N보다 작거나 같은 제곱수들의 합으로 표현, 그 항의 최소 개수 구하기
#greedy 인 줄 알았지만 제곱수들이 배수가 아니고 이전 구조 반복되므로 dp로 풀이함

import sys
input = sys.stdin.readline

N = int(input())
dp = [0] * (N+1) #bottom-up

for i in range(1,N+1):
    dp[i] = i
    for j in range(1,i):
        if (j**2 > i): #j = N을 넘지 않는 제곱수
            break
      
        dp[i] = min(dp[i], dp[i-(j**2)]+1)

print(dp[N])
