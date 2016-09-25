#include "BST.cpp"

using namespace std;

int main() {
  BST * tree = new BST();
  tree->insert(5);
  tree->insert(4);
  tree->insert(7);
  tree->insert(3);
  tree->insert(20);
  tree->inOrd();
  return 0;
}
