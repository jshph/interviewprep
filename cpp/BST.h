
class BST {
  private:
    // to convert to class
    struct Node {
      int data;
      Node* left;
      Node* right;
    };
    Node* root;
    void _inOrd(Node *root);
  public:
    BST();
    void insert(int data);
    void inOrd();
};
