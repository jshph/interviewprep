#include <iostream>

using namespace std;

class LL {
  private:
    struct Node {
      int data;
      Node *next;
    };
    Node *head;
    Node *tail;
  public:
    LL () {
      head = NULL;
      tail = NULL;
    };
    void insertFront(int in) {
      Node *newNode = new Node;
      newNode->data = in;

      if (head == NULL) {
        head = newNode;
        newNode->next = NULL;
        tail = newNode;
      } else {
        newNode->next = head;
        head = newNode;
      }
      return;
    }
    void insertLast(int in) {
      Node * newNode = new Node;
      newNode->data = in;

      if (tail == NULL) {
        head = newNode;
        newNode->next = NULL;
        tail = newNode;
      } else {
        tail->next = newNode;
        tail = newNode;
        newNode->next = NULL;
      }
      return;
    }
    void printNodes() {
      Node *ptr = head;
      while (ptr != NULL) {
        cout << ptr->data << endl;
        ptr = ptr->next;
      }
    }
};

int main() {
  LL list;
  list.insertFront(5);
  list.insertFront(6);
  list.insertLast(7);
  list.insertLast(7);
list.insertLast(7);
list.insertLast(8);

  list.printNodes();
}


