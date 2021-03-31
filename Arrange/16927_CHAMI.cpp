#include <iostream>
#include <algorithm>
using namespace std;
int N, M, R;
int arr[330][330];

void rotate(){

	int rotCnt = min(N, M) / 2;
	
	for (int x = 0; x < rotCnt; x++)
	{
		int stY = x;
		int stX = x;
		int edY = N - 1 - x;
		int edX = M - 1 - x;
		//최소 횟수로만 회전하기
		int roll_R = R % ((N+M)*2-4);
		//while문에서 회전
		while (roll_R--){
			int tmp = arr[stY][stX];
			for (int k = stX; k < edX; k++)
				arr[stY][k] = arr[stY][k + 1]; // 상
			for (int k = edX; k > stX; k--)
				arr[edY][k] = arr[edY][k - 1]; // 하
			for (int k = edY; k > stY + 1; k--)
				arr[k][stX] = arr[k - 1][stX]; // 좌
			for (int k = stY; k < edY; k++)
				arr[k][edX] = arr[k + 1][edX]; // 우

			arr[stY + 1][stX] = tmp;
		}
	}
}

int main(){
	cin.tie(0); cout.tie(0);
	cin >> N >> M >> R;
	if (2 % (min(N, M)) != 0) return 0;

	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			cin >> arr[i][j];
	
	rotate();
	for (int i = 0; i < N; i++){
		for (int j = 0; j < M; j++){
			cout << arr[i][j] << ' ';
		}
		cout << '\n';
	}
	return 0;
}
