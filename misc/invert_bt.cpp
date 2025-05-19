//Inversion of binary tree
#include <iostream>
using namespace std;
//structure for tree
struct node
{
    node *left;
    node *right;
    int data;
};
node *create_tree()
{
    int x;
    cout << "Enter data,-1 to exit ";
    cin >> x;
    cout << x << endl;
    if (x == -1)
        return NULL;
    node *temp = new node;
    temp->data = x;
    cout << "Enter left child of node value " << temp->data << endl;
    node *l = create_tree();
    cout << "Enter right child of node value " << temp->data << endl;
    node *r = create_tree();
    temp->left = l;
    temp->right = r;
    return temp;
}
//inorder traversal
void inorder(node *root)
{
    if (root != NULL)
    {
        inorder(root->left);
        cout << root->data << " ";
        inorder(root->right);
    }
}
void invert(node *root)
{
    if (root == NULL)
        return;
    invert(root->left);
    invert(root->right);
    node* temp=root->left;
    root->left=root->right;
    root->right=temp;
}
int main()
{
    node *root = NULL;
    root = create_tree();
    inorder(root);
    invert(root);
    inorder(root);
    return 0;
}
