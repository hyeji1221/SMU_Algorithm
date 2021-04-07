#include <iostream>
#include <queue>
using namespace std;
int N, K;
int L;
//우 하 좌 상
int dr[] = { 0,1,0,-1 };
int dc[] = { 1,0,-1,0 };
int arr[100][100];
int t[100]; // 시간
char d[100]; //방향
int row, col, dir, ans, idx;
struct Pos
{
	int r, c;
};
queue<Pos> q;

void rotation(char c) {
	if (c == 'L') //반시계방향
		dir = (dir + 7) % 4;
	else //시계방향
		dir = (dir + 1) % 4;
}

void snake_game() {
//맵의 2는 지렁이 표시
arr[0][0] = 2;
//초기 위치를 큐에 넣는다
q.push({ 0,0 });
	
  while (true) {

	row += dr[dir];
	col += dc[dir];
	ans++;
	//범위를 벗어나거나 몸에 닿았을 경우 종료
	if (row < 0 || row >= N || col < 0 || col >= N || arr[row][col] == 2){
	return;
	}

	if (arr[row][col] == 0) { //빈땅
	//큐에서 하나꺼내어 지렁이 크기를 줄인다
	Pos pos = q.front();
	q.pop();
	//몸통을 빈땅으로 바꾸기
	arr[pos.r][pos.c] = 0;
	}
	//머리가 이동하였으므로 해당칸을 지렁이칸으로 변경
	arr[row][col] = 2;
	q.push({ row,col });
	  
	if (ans == t[idx]) { //회전할 시간이면
	rotation(d[idx++]);
	}
}
}
    
int main(){
cin >> N >> K;
for (int i = 0; i < K; i++) {
	int a, b;
	cin >> a >> b;
	
	if(a==1 && b==1) return 0; //종료 조건
	arr[r - 1][c - 1] = 1;
}
	
cin >> L;
for (int i = 0; i < L; i++) {
cin >> t[i] >> dir[i];
}
snake_game();
cout << ans <<'\n';
return 0;
}
