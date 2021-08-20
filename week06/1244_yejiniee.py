import sys
input=sys.stdin.readline
n=int(input()) #스위치개수
switch=list(map(int, input().split())) #스위치상태
on_off={1:0, 0:1} #스위치를 바꿔줌
m=int(input()) #학생 수

for _ in range(m): #학생 수 만큼 반복
    s,num=map(int, input().split())
    
    if (s==1): #남학생일 경우
        i=num
        while (num-1<n):
            switch[num-1]=on_off[switch[num-1]]
            num+=i
                    
    if (s==2): #여학생일 경우
        middle=num-1
        j=1
        
        switch[num-1]=on_off[switch[num-1]]
                    
        while(middle-j>=0 and middle+j<n):
            if switch[middle-j]==switch[middle+j]: #좌우가 대칭이면
                switch[middle-j]=on_off[switch[middle-j]]
                switch[middle+j]=on_off[switch[middle+j]]
            else:
                break
            j+=1
                          
#결과출력
for i in range(n):
    if (i!=0 and i%20==0):
        print()
    print(switch[i], end=' ')
