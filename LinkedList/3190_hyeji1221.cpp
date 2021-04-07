#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// 방향변화
const int dx[] = { 0,1,0,-1 };
const int dy[] = { 1,0,-1,0 };

struct pt {
    int x, y;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    //freopen("../input.txt", "r", stdin);

    int size, apple;
    cin >> size >> apple;
    vector<vector<int> > arr(size + 1, vector<int>(size + 1, 0));

    int a, b;
    while (apple--) {
        cin >> a >> b;
        arr[a][b] = 1; // 사과
    }

    int x = 1, y = 1;
    arr[x][y] = 2; // 뱀
    int dir = 0; // 머리 방향
    queue<pt> snake; // 뱀 몸통
    snake.push({ x,y });

    int cnt, time;
    char cmd;
    int result = 0;
    cin >> cnt >> time;
    while (true) {
        result++;
        x += dx[dir], y += dy[dir]; // 좌표 증감
        // 벽, 뱀 몸통일 경우 출력 후 exit
        if (x < 1 || y < 1 || x > size || y > size
            || arr[x][y] == 2) {
            cout << result;
            break;
        }
        // 빈칸일 경우 꼬리 제거
        else if (arr[x][y] == 0) {
            pt t = snake.front();
            snake.pop();
            arr[t.x][t.y] = 0; // pop 좌표 값을 빈칸으로
        }
        // 머리 추가
        arr[x][y] = 2;
        snake.push({ x, y });

        if (result == time) {
            cin >> cmd;
            if (--cnt) // 다음 시간
                cin >> time;
            // 방향 전환
            if (cmd == 'L')
                dir = --dir < 0 ? 3 : dir;
            else
                dir = ++dir > 3 ? 0 : dir;
        }
    }

    return 0;
}
