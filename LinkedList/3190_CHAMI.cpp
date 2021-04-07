#include <iostream>
#include <queue>
using namespace std;
int N, K; //N 보드크기 2<=N<=100, K 사과 개수 0<=K<=100 // 맨
int L; // 방향변환횟수 1<=L<=100
int arr[100][100]; // 맵
int t[100]; // 시간
char dir[100]; //방향
int row, col, d, ans, idx;
struct Pos
{
	int r, c;
};
//값이 두개뿐이라 pair를 써도 된다.
queue<Pos> q;
//우 하 좌 상 (시계방향)
int dr[] = { 0,1,0,-1 };
int dc[] = { 1,0,-1,0 };
void rotation(char c) {
	if (c == 'L') //반시계방향
		d = (d + 7) % 4;
	else //시계방향
		d = (d + 1) % 4;
}
void game() {
	//맵의 2는 지렁이 표시
	arr[0][0] = 2;
	//초기 위치를 큐에 넣는다.
	q.push({ 0,0 });
	//지렁이는 초기에 오른쪽을 향해 있다.
  while (true) {
//위치 수정
row += dr[d];
col += dc[d];
//시간증가
ans++;
//범위를 벗어나거나 몸에 닿았을 경우 종료
if (row < 0 || row >= N || col < 0 || col >= N || a
return;
}
//빈땅이라면
if (arr[row][col] == 0) {
//큐에서 하나꺼내어 지렁이 크기를 줄인다.
Pos pos = q.front();
q.pop();
//몸통을 빈땅으로 바꾸기
arr[pos.r][pos.c] = 0;
}
//머리가 이동하였으므로 해당칸을 지렁이칸으로 변경
arr[row][col] = 2;
//큐에 넣기
q.push({ row,col });
//현재까지 경과한 시간이 회전시킬 시간이라면
if (ans == t[idx]) {
//회전함수를 통해 회전
rotation(dir[idx++]);
}
}
}
int main(){
cin >> N >> K;
for (int i = 0; i < K; i++) {
int r, c;
cin >> r >> c;
//입력받은 좌표값은 1,1부터 시작하므로 한칸씩값을 뺴준다
arr[r - 1][c - 1] = 1;
}
cin >> L;
for (int i = 0; i < L; i++) {
//시간은 10000이하의 정수
cin >> t[i] >> dir[i];
}
game();
cout << ans;
return 0;
}
