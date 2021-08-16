import sys
input = sys.stdin.readline
n = int(input())
p = [list(map(int, input().split())) for _ in range(n)]

zero = 0
one = 0
n_one = 0


def divide(x, y, n):

    global zero,one,n_one
    check = p[y][x] #첫번째 숫자 주변 탐색

    for i in range(y, y + n):
        for j in range(x, x + n):
            #같지 않은 색상 발견
            if p[i][j] != check:
                n = n // 3 #같은 크기의 9개 종이로 나눔
                #총 9개로 나눈 것에서 같은 과정 실행
                for k in range(3):
                    for l in range(3):
                        divide(x + n * l, y + n * k, n)
                return

    if check == 0:
        zero += 1
        return
    elif check == 1:
        one += 1
        return
    elif check == -1:
        n_one += 1
        return


divide(0,0,n)
print(n_one,zero,one,sep='\n')
