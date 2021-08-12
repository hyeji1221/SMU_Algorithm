import sys

n,k=map(int, sys.stdin.readline().split())
coin=[] #동전을 저장

for i in range(n):
    c=int(sys.stdin.readline())
    coin.append(c)

count=0
coin.sort(reverse=True) #크기가 큰 순서로 바꿔줌

for i in coin:
    if(k==0):
        break
    if k>=i:
        q=k//i 
        count+=q #몫을 count
        k%=i #나머지를 다시 k로 만듦
        
print(count)
