import sys
input = sys.stdin.readline

n, k = map(int, input().split())
arr = list((i+1) for i in range(n))
result = [] #제거될 숫자를 담는 배열

cnt = 0

for i in range(n):
    cnt += (k - 1) #pop하면서 인덱스 변하므로 -1
    cnt %= len(arr) #한 바퀴 돈 후 다시 0부터
    result.append(arr.pop(cnt))

#join: 리스트 -> 문자열 이므로 map을 사용해 정수 리스트인 result 문자열 리스트로 변환
print("<", ", ".join(map(str,result)), ">",sep="")

