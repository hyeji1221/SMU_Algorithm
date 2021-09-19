import sys
n,m=map(int, sys.stdin.readline().split()) #아이들:n 색상:m
jewel=[]
for _ in range(m):
    jewel.append(int(sys.stdin.readline()))

start=1
end=max(jewel)

while start<=end:
    mid=(start+end)//2 
    total=0
    for j in jewel:
        if j%mid==0:
            total+=j//mid
        else:
            total+=(j//mid)+1
    if total<=n:
        end=mid-1
    else:
        start=mid+1

print(start)
