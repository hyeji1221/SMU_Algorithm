M = int(input())
N = int(input())

arr = list([0]*(M+1) for _ in range(M+1))
visited=[False]*(M+1)

#입력받고 연결되어 있는지 저장
for i in range(N):
    a,b = map(int,input().split())
    arr[a][b],arr[b][a]=1,1

#BFS
def virus(v):
    count = 0
    queue = []
    queue.append(v)
    while queue:
        v=queue.pop(0)
        for i in range(1,M+1):
            if not visited[i] and arr[v][i]==1: #방문하지 않았고, 연결이 되어있는지 확인
                count+=1
                visited[i]=True
                queue.append(i)

    return count

#1번부터 바이러스 걸림
visited[1]=True
print(virus(1))
