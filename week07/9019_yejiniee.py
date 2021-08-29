import sys
from collections import deque

def D(n): #n*2
    result=n*2
    if result>9999:
        result%=10000
    return result

def S(n): #n-1
    if n==0:
        return 9999
    else:
        return n-1
    
def L(n): #왼쪽으로 한칸씩 이동
    front=n%1000
    back=n//1000
    result=front*10+back
    return result

def R(n): #오른쪽으로 한칸씩 이동
    front=n%10
    back=n//10
    result=front*1000+back
    return result
    
def bfs(start,end):
    q=deque()
    visited=set()
    q.append((start,""))
    visited.add(start)

    while q:
        num, oper=q.popleft()

        if num==end: 
            return oper
        
        tmp=D(num) #연산결과
        if tmp not in visited:
            visited.add(tmp)
            q.append((tmp, oper+"D"))

        tmp=S(num)
        if tmp not in visited:
            visited.add(tmp)
            q.append((tmp,oper+"S"))

        tmp=L(num)
        if tmp not in visited:
            visited.add(tmp)
            q.append((tmp,oper+"L"))

        tmp=R(num)
        if tmp not in visited:
            visited.add(tmp)
            q.append((tmp,oper+"R"))
    
t=int(sys.stdin.readline())
for _ in range(t):
    a,b=map(int, sys.stdin.readline().split())
    print(bfs(a,b))
