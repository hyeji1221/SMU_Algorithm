import sys
input=sys.stdin.readline
n=int(input()) #포도잔의 개수
w=[0] #와인
for i in range(n):
    w.append(int(input()))
dp=[0] #최대로 마실 수 있는 와인의 양을 저장
dp.append(w[1]) 
if n>1:
    dp.append(w[1]+w[2])

for i in range(3, n+1): 
    dp.append(max(dp[i-1], dp[i-3]+w[i-1]+w[i], dp[i-2]+w[i]))
print(dp[n])
