#include <iostream>
using namespace std;
int g[2190][2190];
long long n;
//arr[0]이 -1 종이의 갯수를 카운트
int arr[3] = { 0,0,0 };

void point(int xs, int ys, int p) {
	//자른 종이가 1x1일 때, 그 숫자를 카운트 해준다.
	if (p == 1) {
    //-1 을 arr[0]에다 카운트
    //나머지도 마찬가지
		arr[g[xs][ys] + 1]++;
		return;
	}

	bool c = false;
	int x = xs;
	int y = ys;
	int temp = g[x][y];

	for (int i = x; i < x + p; i++) {
		for (int j = y; j < y + p; j++) {
			if (g[i][j] != temp) {
        //하나라도 다른 숫자가 있다면 반복문 종료
				c = true; break;
			}
		}
	}

	if (!c) {
    //c가 false 라면 모든 종이의 숫자가 같다. 따라서 카운트
		arr[temp + 1]++;
	}
	else {
    //아니라면 구역을 나누어준다. 재귀호출 사용
		for (int i = x; i < x + p; i+=p/3) {
			for (int j = y; j < y + p; j+=p/3) {
				point(i, j, p / 3);
			}
		}
		/*p = p / 3;
		point(xs, ys, p); //0,0
		point(xs + p, ys, p);  //0,3
		point(xs + p * 2, ys, p);   //0,6
		point(xs, ys + p, p);  //3,0
		point(xs, ys + p * 2, p);  //6,0
		point(xs + p, ys + p, p);  //3,3
		point(xs + p * 2, ys + p * 2, p); //6,6
		point(xs + p, ys + p * 2, p);
		point(xs + p * 2, ys + p, p);
    */
    //냅다 노가다로 쓴 부분ㅋㅋ
	}
	return;
}

int main() {
	ios::sync_with_stdio(0);
	cin >> n;
  //종료 조건 추가
	if (n % 3) return 0;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> g[i][j];
		}
	}
	point(0, 0, n);
  //출력
	cout << arr[0] << '\n' << arr[1] << '\n' << arr[2] << '\n';
	return 0;
}
