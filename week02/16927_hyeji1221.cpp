// 바깥쪽 층에서 안쪽 층으로 들어오면서 rotate 수행
#include <iostream>
using namespace std;
int map[300][300];
int N, M, R;
// 오, 아, 왼, 위
int da[] = { 0,1,0,-1 };
int db[] = { 1,0,-1,0 };

void rotate(int start, int len) { // start : 시작 지점
	int r = R % len; // len만큼 돌면 한바퀴를 도는 것이기에 modulo 연산을 통해서 R 값을 줄여준다

	for (int i = 0; i < r; i++) { // r칸 전진
		int startVal = map[start][start]; //start 위치에 값의 씌어지기에 없어지므로 미리 저자해놓음
		int a = start;
		int b = start;

		int k = 0;
		while (k < 4) { // 사각형 4분면 다 돌면 끝
			int na = a + da[k]; //map[na][nb]는 옮길 대상 (map[a][b]로 옮겨야 함)
			int nb = b + db[k];

			if (na == start && nb == start) break;
			if (start <= na && na < N - start && start <= nb && nb < M - start) {
				map[a][b] = map[na][nb];
				a = na;
				b = nb;
				
			}
			else { //다음에 옮길 칸이 배열 범위 넘어가버리면 해당 라인은 다 옮긴거라서 k 증가
				k++;
			}
		}
		map[start + 1][start] = startVal; //처음에 시작지점 빼놨던거 마지막에 빈 자리에 넣어줌.
		//cout << map[start + 1][start];
	}
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	cin >> N >> M >> R;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
		}
	}
	int n = N;
	int m = M;
	int layer = min(N, M) / 2; // 층 개수
	for (int i = 0; i < layer; i++) {
		rotate(i, 2 * n + 2 * m - 4); // 2 * N + 2 * M - 4 = 바깥쪽 박스의 칸수 -> 이 만큼 돌면 한바퀴 돌아옴
		n -= 2; // 층 안으로 들어갈 때마다 가로 세로 2씩 줄어듦
		m -= 2;
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cout << map[i][j] << " ";
		}
		cout << "\n";
	}

}
