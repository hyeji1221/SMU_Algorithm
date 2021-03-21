import sys
input = sys.stdin.readline
str = input().rstrip()

ans = "" #공백이 나오기 전 배열 저장
result = "" #공백이 나온 후, 이전 단어와 합침
tag_bool = False #태그 여부 확인

for i in str:
    # tag가 시작되지 않을 때
    if not tag_bool:
        if i == "<":
            tag_bool= True
        elif i==" ":
            ans = ans + i
            result = result + ans
            #초기화
            ans = ""
        else:
            #반대로 저장
            ans = i+ans
            
    # "<"가 시작되면
    if tag_bool:
        #순서대로 저장
        ans = ans + i
        if i == ">":
            tag_bool = False
            result = result + ans
            ans = ""

# 마지막 단어는 공백이 없어 result와 합쳐지지 않아서 따로 추가
print(result+ans)
