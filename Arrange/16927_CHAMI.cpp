#include <iostream>
#include <stdio.h>
#include <algorithm>
using namespace std;
int N, M, R; // 회전 수
int arr[302][302];

void rotate(){
  int rotCnt = min(N, M) / 2;
  for(int j = 0; j < rotCnt; j++){
    int stY = j;
    int stX = j;
    int edY = N-1-j;
    int edX = M-1-j;
    // 제자리로 돌아오기 까지의 값을 나누어 최소 횟수로만 회전
    int tR = R % (2 * (edX-stX+1) + 2 * (edY-stY+1) - 4);
    // R번 회전
    while(tR--){
      int tmp = arr[stY][stX];
      for (int k = stX; k < edX; k++)
      arr[stY][k] = arr[stY][k + 1]; // 상
      for (int k = stY; k < edY; k++)
      arr[k][edX] = arr[k + 1][edX]; // 우
      for (int k = edX; k > stX; k--)
      arr[edY][k] = arr[edY][k - 1]; // 하
      for (int k = edY; k > stY+1; k--)
      arr[k][stX] = arr[k - 1][stX]; // 좌
      arr[stY+1][stX] = tmp;
    }
  }
}

int main(){
  cin.tie(0);
  cout.tie(0);
  cin >> n,m,r;
  for(int a=0; a<n; a++)
    for(int b=0; b<m; b++)
      cin >> arr[a][b];
  
  rotate();
  
  for(int a=0; a<n; a++){
    for(int b=0; b<m; b++){
      cout << arr[a][b];
    }
    cout << '\n';
  }
return 0;  
}
