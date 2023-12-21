class Node {

    int value;
    Node next[];

    Node(int value) {
        this.value = value;
        this.next = new Node[5];
        // this.next= new Node[];

        // Node n[]=;
        // for(Node i:next){

        // }
    }

}

class Linked {

    // private static Node head;

    // void add(int value) {
    //     while (head.next[0] != null) {
    //         head = head.next[0];
    //     }

    //     // add to end
    //     Node newNode = new Node(value);
    //     head.next[0] = newNode;
    // }

    // void printList() {
    //     while (head != null) {
    //         System.out.println(head.value);
    //         head = head.next[0];
    //     }
    // }

    // Tree createTree() {
    //     Tree root = new Tree();
    //     while (head.next[0] != null) {
    //         root = createTree(root.root, head);
    //     }
    //     return root;
    // }

    // Tree createTree(Node root, Node head) {
    //     if (root == null)
    //         return new Tree(head);
    //     if (root.value < head.value)
    //         root.next[0] = createTree(root.next[0], head).root;
    //     else
    //         root.next[1] = createTree(root.next[1], head).root;
    //     return new Tree(root);
    // }

    public static void main(String[] args) {
        // head = new Node(1);
        // Linked list = new Linked();

        // // add
        // list.add(10);
        // list.add(1212);
        // list.add(3);
        // list.add(1);
        // list.add(2);
        // list.add(5);
        // Tree root = list.createTree(null, head);
        // root.print(root.root);
        // // list.printList();
        String a = "A";
String b = "A";
        System.out.println(a==b);

    }
}

class Tree {
    Node root;

    Tree(Node n) {
        root.value = n.value;
        root.next[0] = null;
        root.next[1] = null;
    }

    void print(Node root) {
        if (root == null)
            return;
        print(root.next[0]);
        print(root.next[1]);
        System.out.println(root.value);
    }
}