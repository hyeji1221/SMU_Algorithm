#include <iostream>
using namespace std;
char island[15][15];
char result[15][15];
int minX = 0, maxX = 0;
int minY = 0, maxY = 0;


void printIsland(){
    for (int a = minX; a <= maxX; a++) {
		for (int b = minY; b <= maxY; b++) {
			cout << result[a][b];
		}
		cout << '\n';
	}
}


int main() {
    cin.tie(0);
	int con, R, C;
	cin >> R >> C;

	for (int i = 0; i < 15; i++) {
		for (int j = 0; j < 15; j++) {
			if (i>0 && j>0 && i <= R && j <= C) {
                //R*C 크기 만큼 입력값으로 채워넣음
				cin >> island[i][j];
			}
			else { //나머지 공간은 바다로 채움
				island[i][j] = '.';
			} //결과값 전체는 바다로 둠
			result[i][j] = '.';
		}
	}

	for (int i = 1; i <= R; i++) {
		for (int j = 1; j <= C; j++) {
            //X를 찾았으면, con를 0으로
			if (island[i][j] == 'X') {
				con = 0;
				if (island[i-1][j] == '.') {
					con++;
				}//위가 바다
				if (island[i][j - 1] == '.') {
					con++;
				}//왼쪽이 바다
				if (island[i + 1][j] == '.') {
					con++;
				}//아래가 바다
				if (island[i][j + 1] == '.') {
					con++;
				}//오른쪽이 바다
                
				if (con <= 2) { //삼면, 사면이 바다가 아님
                    //결과값은 X. (가라앉지 않았음) 기본값이 바다이므로 가라앉을 때는 변경x
					result[i][j] = 'X';
					if (minX == 0 || minX > i) {
						minX = i;
					}
					if (maxX <= i) {
						maxX = i;
					}
					if (minY == 0 || minY > j) {
						minY = j;
					}
					if (maxY <= j) {
						maxY = j;
					}
                    //min값과 max값을 갱신
				}			
			}
		}
	}

	printIsland();
	return 0;
}
