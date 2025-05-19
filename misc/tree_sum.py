# program to find
# 1. sum of all nodes of a tree
# 2. sum of parent nodes of of node value x

class node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def create_bt():
    x = int(input('Enter data,-1 to exit'))
    if x == -1:
        return None
    temp = node(x)
    print('Enter data for left node value ', x)
    temp.left = create_bt()
    print('Enter data for right child of node value ', x)
    temp.right = create_bt()
    return temp


def inorder(root):
    if(root != None):
        inorder(root.left)
        print(root.data, end=' ')
        inorder(root.right)

# function to find sum of all nodes in tree


def sum_nodes(root):
    s = 0
    if root != None:
        s += sum_nodes(root.left)
        s += sum_nodes(root.right)
        s += root.data
    return s


psum = 0


def parent_sum(root, previous_root_value, key):
    global psum
    # check if current value is equal to val and add the previous root value to it
    if root == None:
        return
    if root.data == key:
        psum += previous_root_value
    # check for subtrees
    parent_sum(root.left, previous_root_value=root.data, key=key)
    parent_sum(root.right, previous_root_value=root.data, key=key)


# utility function to find out sum of tree with root node given
def node_sum(root):
    if root == None:
        return 0
    return root.data+node_sum(root.left)+node_sum(root.right)

# function to find out if every node except the leaves are the sum of the left and right subtrees or not


def tree_sum(root):
    if root.left == None or root.right == None:
        return True
    if tree_sum(root.left) and tree_sum(root.right):
        left_sum = node_sum(root.left)
        right_sum = node_sum(root.right)
        if (left_sum+right_sum) == root.data:
            return True
        else:
            return False
    return False


root = create_bt()
input_num = int(input('Enter number for finding parent sum'))
parent_sum(root, 0, input_num)
print(psum)
print(tree_sum(root))
