import sys
input = sys.stdin.readline

str1 = list(input().rstrip())
str2 = []
L = int(input())

for i in range(L):
    cmd = input().rstrip()
    if (cmd[0] == "L" and str1):
        str2.append(str1.pop())
    elif (cmd[0]== "D" and str2 ):
        str1.append(str2.pop())
    elif (cmd[0]== "B" and str1):
        str1.pop()
    elif (cmd[0]== "P"):
        str1.append(cmd[2])

print(''.join(str1+str2[::-1]))
