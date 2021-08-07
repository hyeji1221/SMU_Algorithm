#include <iostream>
using namespace std;

int mmin(int a, int b){
	return a <= b ? a : b;
}

/*기본적 logic
 전 dp에서 i을 더한다 (dp[i] = min(dp[i], dp[i-1]+1)
 예외: 제곱수 (4=2^2, 방법이 1가지가 나옴)
*/

int main() {
	int n = 0;
	int dp[100001];
	cin >> n;

	dp[0] = 0;//제곱근 있는 수 일때 사용된다. ex) 4, 9, 16
	for (int i = 1; i <= n; ++i) {
		dp[i] = i;//1^2으로만 제곱수 합 꾸렸을 때 개수 대입, 최악의 상황인 것
		for (int j = 1; j * j <= i; ++j) {
			dp[i] = mmin(dp[i], dp[i - j * j] + 1);
		}//n까지 전부 검사할 필요 없음. n=10이면 3^2 + 1이니 3까지만 검사해도 됨
	}
	cout << dp[n];
	return 0;
}
