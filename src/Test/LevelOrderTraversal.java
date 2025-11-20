package Test;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    //Given the root of a binary tree,
    // the task is to print level order traversal in a way that
    // nodes of all levels are printed in separate lines.
    Node root;

    public static void main(String[] args) {
        LevelOrderTraversal tree = new LevelOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.right.right = new Node(5);

        tree.printLevelOrderTraversal();
    }

    void printLevelOrderTraversal() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curData = queue.poll();
                System.out.print(curData.data + " ");

                if (curData.left != null) {
                    queue.add(curData.left);
                }

                if (curData.right != null) {
                    queue.add(curData.right);
                }
            }
            System.out.println();
        }

    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}