# 별찍기
import sys
input = sys.stdin.readline
n = int(input())

len = n * 4 - 3  # 가로 별 개수 -> 공백 리스트를 위해
star = [[' ' for _ in range(len)] for _ in range(len)] #공백으로 채워 둠

def draw_star(n, y, x):

    len = n * 4 -3 #n에 따라 달라지는 가로 길이 재정의
    
    if n == 1:
        star[y][x] = "*"
        return

    for i in range(len):
        star[y][x+i] = "*" #윗변
        star[y+i][x] = "*" #왼쪽 높이
        star[y+i][x+len-1] = "*" #오른쪽 높이
        star[y+len-1][x+i] = "*" #아랫변

    draw_star(n-1, y+2, x+2) #처음 시작 위치

draw_star(n,0,0)

for s in star:
    print(''.join(s)) #join: 리스트를 문자열
