import sys
input = sys.stdin.readline

str1 = list(input().rstrip()) # 커서의 왼쪽 리스트
str2 = [] # 커서의 오른쪽 리스트
L = int(input())

for i in range(L):
    cmd = input().rstrip()
    # L , str1이 비어있지않음
    # 커서 왼쪽으로 이동 -> 커서 왼쪽에 있던 문자 하나가 커서 오른쪽으로 이동
    if (cmd[0] == "L" and str1):
        str2.append(str1.pop())
    # D, str2가 비어있지않음
    elif (cmd[0]== "D" and str2 ):
        str1.append(str2.pop())
    # B, str1이 비어있지않음
    elif (cmd[0]== "B" and str1):
        str1.pop()
    # P 
    elif (cmd[0]== "P"):
        str1.append(cmd[2])

# str2 -> append 했기때문에 역으로 저장됨
# str2[::-1] 이용해서 역으로 출력
print(''.join(str1+str2[::-1]))
