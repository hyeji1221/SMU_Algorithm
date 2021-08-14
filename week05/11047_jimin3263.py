#입력 값 배수 -> 그리디

n,k = map(int,input().split())
coin=[]
for i in range(n):
    coin.append(int(input()))

#내림차순으로 재배열
coin.sort(reverse=True)

count=0
for i in coin:
    #k보다 작거나 같다면
    if(k>=i):
        count+= k//i #개수 저장
        k%=i #나머지 구함

print(count)
