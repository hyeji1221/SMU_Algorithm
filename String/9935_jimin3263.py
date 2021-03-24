import sys
input = sys.stdin.readline

str1 = input().rstrip()
str2 = input().rstrip()

stack = []
for i in str1:
    stack.append(i)
    if (i==str2[-1]):
        if(str2 == ''.join(stack[-len(str2):])):
            del stack[-len(str2):]
if stack:
    print(''.join(stack))
else:
    print("FRULA")
