#include <iostream>
#include <string>
using namespace std;
string s1, s2, ans;
bool flag; // 폭탄 문자열 유무 체크
void bomb_check(int s2len) {
	for (int i = 0; i < s1.size(); i++) {
		ans += s1[i];
		if (s1[i] == s2[s2len - 1] && i >= s2len - 1) { 
			// s2의 가장 끝 단어와 비교한다 && 만약 i가 더 작으면 s2 길이보다 지나온 횟수가 적은 것이기에 같을 수가 없음
			flag = true;
			for (int j = 0; j < s2len; j++) {
				if (ans[ans.size() - s2len + j] != s2[j]) { 
					// s2의 마지막 단어와 비교했기 때문에 s2 길이만큼 뺴서 처음 단어부터 다시 비교하기
					flag = false;
					break;
				}
			}
			if (flag) { // 폭탄 문자열이 포함되어 있으면
				for (int j = 0; j < s2len; j++) {
					ans.pop_back(); //ans의 제일 뒤의 원소 제거
				}
			}
		}
	}
	if (ans.empty())
		cout << "FRULA"<<"\n";
	else
		cout << ans << "\n";
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	cin >> s1;
	cin >> s2;
	bomb_check(s2.length());
}
