#6603
#재귀
def func(s, l):
    if l == 6: #로또 길이 6개 채우면 출력  
        for i in range(6):
            print(result[i], end=' ')
        print()
        return
    for i in range(s, len(arr)):
        result[l] = arr[i]#입력받은 배열 1부터 result에 담음, return, 반복문 통해서 들어가지 않았던 요소 넣음  
        func(i + 1, l + 1)

result = [0]*6

while (True):
    arr =list(map(int,input().split()))
    if(arr[0]==0):# 0 입력 받으면 끝내도록  
        break
    func(1, 0)
    print()
