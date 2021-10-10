import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int,input().split()))

d = list(([0] * 21)for _ in range(n-1)) #0~20 총 21 범위의 숫자만 가능
d[0][arr[0]] = 1

#d[arr인덱스][계산결과]
for i in range(1, n - 1):
    for j in range(21):
        if d[i - 1][j] != 0: 
            next_value = arr[i]
            if 0 <= j + next_value <= 20:
                d[i][j + next_value] += d[i - 1][j]
            if 0 <= j - next_value <= 20:
                d[i][j - next_value] += d[i - 1][j]

print(d[n - 2][arr[n - 1]]) #계산 결과가 마지막과 일치한 횟수만 출력  
