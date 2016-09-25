#include "BST.h"
#include <iostream>

using namespace std;
BST::BST() {
  root = 0;
}

void BST::insert(int data) {
  Node *newNode = new Node;
  newNode->left = 0;
  newNode->right = 0;
  newNode->data = data;

  if (this->root == 0) {
    this->root = newNode;
  } else {
    Node *ptr = this->root;
    Node *parent = ptr;
    while (ptr) {
      parent = ptr;
      if (data < ptr->data)
        ptr = ptr->left;
      else
        ptr = ptr->right;
    }
    if (data < parent->data)
      parent->left = newNode;
    else
      parent->right = newNode;
  }
}

void BST::inOrd() {
  if (root != 0)
    BST::_inOrd(root);
}

void BST::_inOrd(Node *root) {
  if (root->left != 0) {
    BST::_inOrd(root->left);
  }
  cout << root->data << endl;
  if (root->right != 0) {
    BST::_inOrd(root->right);
  }
}

