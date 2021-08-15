#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int K;
vector<int> values;

int count() {
   int c = 0; //최솟값을 저장할 변수
  //반복문 i는 뒤에서부터 (큰 수부터)
   for (int i = values.size() - 1; i >= 0; i--) {
      if (K == 0) { //끝났으면(금액이 0이 되면) 값을 리턴
         return c;
      }
      if (values[i] <= K) { //금액이 남아있으면 계산
         int many = K / values[i];
         c += many; //계산 횟수를 더해준다
         K -= many * values[i];
      }
   }
   return c;
}

int main() {
   cin.tie(0); cout.tie(0);
   int N;
   cin >> N >> K;
   for (int i = 0; i < N; i++) {
     //입력에 벡터를 사용
      int tmp;
      cin >> tmp;
      values.push_back(tmp);
   }
   cout << count();
   return 0;
}
