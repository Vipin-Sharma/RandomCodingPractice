// Java program to do level order
// traversal line by line
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GFG_LCS {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Prints level order traversal line
    // by line using two queues.
    static void levelOrder(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();

        // Pushing root node into the queue.
        q.add(root);

        // Pushing delimiter into the queue.
        q.add(null);

        // Executing loop till queue becomes
        // empty
        while (!q.isEmpty()) {

            Node curr = q.poll();

            // condition to check the
            // occurence of next level
            if (curr == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    System.out.println();
                }
            } else {
                // Pushing left child current node
                if (curr.left != null)
                    q.add(curr.left);

                // Pushing right child current node
                if (curr.right != null)
                    q.add(curr.right);

                System.out.print(curr.data + " ");
            }
        }
    }

    // Driver function
    public static void main(String[] args) {

        /*Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        levelOrder(root);*/
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String a = in.next();
            String b = in.next();
            printLongestCommonSubsequence(a, x, b, y);
        }

    }

    /*
        1
        76 32
        JATAXGPDMYLDXUKDNFTPRRUMBMEMLROWRHWOQNTCLGHLCRORZHGSBAECPLPCCDYVNXMDMFHAOPLQ
        IZKHIQBJTIMITDKXIKSXJECWMKWABHSL
        17

        answer is 12 here I get 17
     */

    private static void printLongestCommonSubsequence(String first, int x, String second, int y) {
        //System.out.println(a +" "+ x +" "+ b + " " + y);

        char[] charArray1 = first.toCharArray();
        char[] charArray2 = second.toCharArray();

        int[][] a = new int[x+1][y+1];
        int[][] lcs = new int[x+1][y+1];

        for (int i = 0, j= 0; j <=y ; j++) {
            a[i][j] = 0;
            lcs[i][j] = 0;
        }
        for (int i = 0, j= 0; i <=x ; i++) {
            a[i][j] = 0;
            lcs[i][j] = 0;
        }

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if(charArray1[i-1] == charArray2[j-1]){
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                }else {
                    lcs[i][j] = Math.max( lcs[i-1][j], lcs[i][j-1] );
                }
            }
        }
        System.out.println(lcs[x][y]);
    }
}