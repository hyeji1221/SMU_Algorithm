#큐를 이용
import sys
n,k=map(int, sys.stdin.readline().split())
queue = [x for x in range(1,n+1)]

print('<', end='')
while(len(queue)>1):
    for i in range(1,k):
        p=queue.pop(0) 
        queue.append(p) # 1부터 k-1번째 사람은 맨끝으로 이동
    
    print(queue.pop(0), end=', ') # k번째 사람을 큐에서 제거
    
print("%d>" %queue.pop(0))
