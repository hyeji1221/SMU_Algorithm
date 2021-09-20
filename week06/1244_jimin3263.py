import sys
input = sys.stdin.readline

n = int(input()) #스위치 개수
arr =[-1] + list(map(int,input().split())) #인덱스 1부터 시작하기위해 -1 추가해둠

m = int(input()) #학생 수

def change(num):
    if arr[num] == 0:
        arr[num] = 1
    else:
        arr[num] = 0


for i in range(m):
    gender, cnt = map(int, input().split()) #성별, 숫자
    if(gender == 1): #남자
        for i in range(cnt, n+1, cnt): #배수만큼 변경
            change(i)

    if(gender == 2): #여자 cnt+-1 .. 찾아가기, 왼쪽 0되거나 오른쪽 n-1되면 종료
        change(cnt) 
        for i in range(1,n//2):
            if 1 > cnt-i or cnt+i > n: #범위 벗어나면 break
                break
            if arr[cnt-i] == arr[cnt+i]:
                change(cnt-i)
                change(cnt+i)
            else:
                break

for i in range(1,n+1):
    print(arr[i], end = " ")
    if i % 20 == 0:
        print()
