'''
#ver1(시간초과ㅠㅠ)
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
'''

#ver.2
import sys
n,k=map(int, sys.stdin.readline().split())
queue = [x for x in range(1, n+1)]

answer = []   # 제거된 사람들을 넣을 배열
num = 0  # 제거될 사람의 번호

for _ in range(n):
    num += k-1  
    if num >= len(queue):   #num이 큐의 크기보다 커지면
        num = num%len(queue) 
 
    answer.append(str(queue.pop(num))) #제거된 사람을 넣음
    
print("<",", ".join(answer)[:],">", sep='')
