#include <iostream>
#include <cstring>
using namespace std;

int R, C;
int dy[4] = { +1, 0, 0, -1 };
int dx[4] = { 0, +1, -1, 0 };

bool isValid(int y, int x)
// 주어진 좌표 (y,x) 가 유효하면 true 를 반환, 그 외 false 를 반환 
{
    return y >= 0 && y < R&& x >= 0 && x < C;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> R >> C;
    char arr1[10][10];
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cin >> arr1[i][j];
        }
    }

    char arr2[10][10]; // 50년 후 지도 
    memcpy(arr2, arr1, sizeof(arr2));

    // 출력해야되는 직사각형 지도의 왼쪽 위 좌표, 오른쪽 아래 좌표 초기화
    // ul - upper left, lr - lower right 
    int uly = R, ulx = C, lry = -1, lrx = -1;

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (arr1[i][j] == 'X') {
                int sea = 0; // 인접한 바다칸 개수 
                for (int k = 0; k < 4; k++) {
                    int ay = i + dy[k];
                    int ax = j + dx[k];
                    if (!(isValid(ay, ax)) || arr1[ay][ax] == '.') { // 지도를 벗어나는 경우는 바다이므로 || .은 바다
                        sea++;
                    }
                }
                if (sea >= 3) { // 인접한 바다칸 개수가 3개 이상이면
                    arr2[i][j] = '.'; // 50년 후 잠김 
                }
                else { // 인접한 바다칸 개수가 3개 미만이면 50년 후 잠기지 않음 
                 // 잠기지 않는 땅 발견할 경우 지도의 왼쪽 위, 오른쪽 아래 좌표 갱신
                    uly = min(uly, i); // 왼쪽 위 y 좌표 갱신 
                    ulx = min(ulx, j); // 왼쪽 위 x 좌표 갱신 
                    lry = max(lry, i); // 오른쪽 아래 y 좌표 갱신 
                    lrx = max(lrx, j); // 오른쪽 아래 x 좌표 갱신 
                }
            }
        }
    }

    for (int i = uly; i <= lry; i++) {
        for (int j = ulx; j <= lrx; j++) {
            cout << arr2[i][j];
        } cout << "\n";
    }
}

