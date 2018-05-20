import java.util.LinkedList;

/**
 * Created by nitinkumarsharma on 5/6/18.
 */

class Node {

    int data;
    Node left;
    Node right;
    Node next;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.next = null;
    }

    @Override
    public String toString(){
        return "Data: " + this.data + " Next: " + this.next;
    }
}

class QueueWithLevel extends LinkedList<Node> {
    int level;

    QueueWithLevel() {
        /*this.level = level;
        this.element = element;*/
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.createBinaryTree();
        //binaryTree.printLevelOrderBFS(root);
        //binaryTree.printLevelOrderLineByLine(root);
        //binaryTree.populateTreeLineByLineWithInt(root);
        binaryTree.populateTreeWithNextPointer(root);
    }

    private void populateTreeWithNextPointer(Node root) {
        QueueWithLevel queue = new QueueWithLevel();
        queue.level = 0;
        queue.add(root);
        queue.add(null);

        Node prev = null;
        Node node;

        while (!queue.isEmpty()) {
            node = queue.poll();

            if (node == null) {
                prev = null;
                if (!queue.isEmpty()) {
                    queue.add(null);
                    System.out.println();
                }
            } else {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                System.out.print(node.data + " ");
            }
            if (prev != null) {
                prev.next = node;
                prev = node;
            }else {
                prev =node;
            }
        }
    }

    private void populateTreeLineByLineWithInt(Node root) {

    }

    private void printLevelOrderLineByLine(Node root) {
        QueueWithLevel queue = new QueueWithLevel();
        queue.level = 0;
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    System.out.println();
                }
            } else {
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                System.out.print(node.data + " ");
            }
        }
    }

    private void printLevelOrderBFS(Node root) {
        QueueWithLevel queue = new QueueWithLevel();
        queue.level = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.data + " ");

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        System.out.println();
    }

    private Node createBinaryTree() {
        Node r = new Node(5);
        r.left = new Node(3);
        r.right = new Node(4);
        r.left.left = new Node(1);
        r.left.left.left = new Node(8);
        r.right.left = new Node(2);
        r.right.right = new Node(6);
        r.right.right.left = new Node(9);
        return r;
    }




}
