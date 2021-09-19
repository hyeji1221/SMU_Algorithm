import sys
input = sys.stdin.readline

n = int(input())
#SK -> CY 
#1 or 3가져감 -> 마지막 가져가는 사람 이김
#1-> SK, 2 -> CY, 3 -> SK, 4 == 1 + 3 -> CY, 5 == 1 + 3 + 1 -> SK

if n%2 == 0:
    print("CY")
else:
    print("SK")
