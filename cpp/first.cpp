#include <iostream>
#include <vector>

using namespace std;

int main() {
  vector<int> *v = new vector<int>();
  for (int i = 0; i < 12; i++) {
    v->push_back(i*12);
  }

  for (int i = 0; i < v->size(); i++) {
    cout << v->at(i) << " ";
  }
  return 0;
}
