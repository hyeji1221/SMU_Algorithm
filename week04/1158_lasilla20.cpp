#include <iostream>
#include <queue>
using namespace std;
int n, k;

int main() {
	cin >> n >> k;

	/*큐로 구현
	큐에 맨앞에 있는 사람을 k-1번 뒤로 보낸다
	k번째 사람을 pop*/

	queue<int> cir;
	for (int i = 0; i < n; i++)
		cir.push(i + 1);
	cout << "<";

	while (!cir.empty()) {
		//k-1만큼 돌기
		for(int i=0; i<k-1; i++) {
		cir.push(cir.front());
		cir.pop();
		}

		// K번째 사람을 제거, size=1 이면 마지막 숫자
		if (cir.size() != 1)
			cout << cir.front() << ", ";
		else
			cout << cir.front();
		cir.pop();
	}
	cout << ">";
	return 0;
}
