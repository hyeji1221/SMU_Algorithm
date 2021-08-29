import sys
from itertools import combinations
#조합
while True:
    S=list(map(int, sys.stdin.readline().split()))
    if S==[0]:
        break
    del S[0]
    S= list(combinations(S,6))
    for i in S:
        for j in i:
            print(j, end=' ')
        print()
    print()
