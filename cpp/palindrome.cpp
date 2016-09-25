#include <iostream>
#include <vector>

using namespace std;
bool isPalindrome(vector<char> &);

int main() {
  char ia[] = {'a','b','c','b','a'};
  vector<char> vec (ia, ia + sizeof(ia)/sizeof(char));
  cout << isPalindrome(vec);
  return 0;
}

bool isPalindrome(vector<char> &vec) {
  for (int i = 0; i < vec.size(); i++) {
    if (vec[i] != vec[vec.size() - i - 1])
      return false;
  }
  return true;
}
