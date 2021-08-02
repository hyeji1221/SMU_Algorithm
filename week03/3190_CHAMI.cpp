#include <iostream>
#include <queue>
using namespace std;
int N, K, L;
//우 하 좌 상 (시계방향)
int dr[] = { 0,1,0,-1 };
int dc[] = { 1,0,-1,0 };
int arr[105][105]; //맵
int t[100]; //시간
char dir[100]; //방향
int row, col, d, ans, idx;
struct Pos
{
	int r, c;
};
queue<Pos> q;

void rotation(char c) {
	if (c == 'L') //반시계방향
		d = (d + 7) % 4;
	else if (c == 'D') //시계방향
		d = (d + 1) % 4;
	else return;
}
void snake_game() {
	
	arr[0][0] = 2; //맵의 2는 지렁이 표시
	q.push({ 0,0 }); //초기 위치를 큐에 넣음

	while (true) {

		row += dr[d];
		col += dc[d];
		ans++;
		//범위를 벗어나거나 몸에 닿았을 경우 종료
		if (row < 0 || row >= N || col < 0 || col >= N || arr[row][col] == 2) {
			return;
		}
		
		if (arr[row][col] == 0) { //빈땅
			Pos pos = q.front();
			q.pop(); //지렁이 크기 줄이기
			arr[pos.r][pos.c] = 0;
		}
		//머리가 이동하였으므로 해당칸을 지렁이칸으로 변경
		arr[row][col] = 2;
		q.push({ row,col });

		//현재까지 경과한 시간이 회전시킬 시간이라면
		if (ans == t[idx]) {
			rotation(dir[idx]);
			idx++;
		}
	}
}

int main() {
	cin >> N >> K;
	for (int i = 0; i < K; i++) {
		int r, c;
		cin >> r >> c;
		if (r == 1 && c == 1) return 0; //종료 조건
		arr[r - 1][c - 1] = 1;
	}
	cin >> L;
	for (int i = 0; i < L; i++) {
		cin >> t[i] >> dir[i];
	}

	snake_game();
	cout << ans;
	return 0;
}
