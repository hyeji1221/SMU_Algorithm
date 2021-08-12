import sys
n=int(sys.stdin.readline()) #컴퓨터의 수
c=int(sys.stdin.readline()) #컴퓨터 쌍의 수

graph=[[]*n for _ in range(n+1)]
for _ in range(c): #그래프 구현
    a,b=map(int,sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)
    
visited=[False]*(n+1) #방문여부
result = [] #감염vertex 저장

def dfs(v):
    visited[v] = True
    for i in graph[v]:
        if visited[i] == False:
            result.append(i)
            dfs(i)
    return len(result) #감염된 v의 수

print(dfs(1))
