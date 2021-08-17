#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
using namespace std;
int N, K;
int cou = 0;
bool visit[101];
vector<int> g[101];
stack<int> s;

void dfs() {
  //스택을 모두 비울 때까지 반복
	while (!s.empty()) {
		int top = s.top();
		s.pop();
    //s(=1)과 연결된 컴퓨터(=g[top])를 모두 방문하는 반복문
		for (const int& n : g[top]) {
			if (visit[n] == false) {
				s.push(n);
				visit[n] = true;
        //방문하면 카운트
				cou++;
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(0);

	scanf("%d", &N);
	scanf("%d", &K);
	if (N > 100) return 0;

	//연결리스트로 입력
  //k만큼 반복
	for (int i = 0; i < K; i++) {
		int u, v;
		scanf("%d %d", &u, &v);
		g[u].push_back(v);
		g[v].push_back(u);
	}

  //시작 지점은 1, 방문으로 설정
	s.push(1);
	visit[1] = true;

  //깊이 우선 탐색 실행
	dfs();
	printf("%d\n", cou);
	return 0;
}
