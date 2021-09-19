import sys
input = sys.stdin.readline

n = int(input())
#SK -> CY 출력
#1 or 3가져감 -> 마지막 가져가는 사람 짐 -> 1이랑 반대 상황 ..?

if n%2 == 0:
    print("SK")
else:
    print("CY")

