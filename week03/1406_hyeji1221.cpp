#include <iostream>
#include <string>
#include <list>

using namespace std;

int main() {
    int n;
    string s;
    cin >> s;
    cin >> n;
    list<char> l(s.begin(), s.end());
    auto now = l.end();

    while (n--) {
        char tmp;
        cin >> tmp;

        if (tmp == 'L') { // 커서 왼쪽으로
            if (now != l.begin()) {
                now--;
            }
        }
        else if (tmp == 'D') { // 커서 오른쪽으로
            if (now != l.end()) {
                now++;
            }
        }
        else if (tmp == 'B') { // 커서 왼쪽 문자 삭제
            if (now != l.begin()) {
                now = l.erase(--now);
            }
        }
        else if (tmp == 'P') { // c 문자 추가
            char c;
            cin >> c;
            l.insert(now, c);
        }
    }
    for (auto it = l.begin(); it != l.end(); it++) {
        cout << *it;
    }
    return 0;
}
