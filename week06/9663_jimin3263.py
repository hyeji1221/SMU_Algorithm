#9663
#퀸이 같은 행, 열, 대각선에 없도록 체크
#백트래킹 -> 시간 초과 / 브루트포스, 조건 두도록 함
import sys
input = sys.stdin.readline

n = int(input()) #같은 열, 대각선에 안겹치게 퀸 놔둠
arr = [-1] * n  #col 저장
cnt = 0

def backtracking(row):
    global cnt
    if row == n: #끝에 도달 -> 재귀 빠져나감
        cnt += 1
        return

    else:
        for col in range(n):
            arr[row] = col #일단 놔두고
            for j in range(row):
                if arr[j] == arr[row] or (abs(j - row) == abs(arr[j] - arr[row])): #같은 열, 대각선 확인
                    break
            else:
                backtracking(row+1) #모두 통과하면 다음 행


backtracking(0)
print(cnt)
