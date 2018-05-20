/**
 * Created by nitinkumarsharma on 8/19/17.
 */

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        /*return String.valueOf(val) + " next: " + next!=null ? " End " : next.toString();*/
        return String.valueOf(val);
    }
}

public class Solution {

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(8);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;

        Solution sol = new Solution();
        System.out.println();
        /*sol.printNodes(sol.reorderList(a));*/
        /*sol.printNodes(sol.swapPairs(a));*/
        sol.printNodes(sol.removeNthFromEnd(a, 8));
    }

    public int minPathDP(int[][] cost, int mincostpath[][], int m, int n) {

        if (m == 0 && n == 0) return cost[m][n];

        if (m == 0) mincostpath[0][n] = cost[0][n];
        if (n == 0) mincostpath[m][0] = cost[m][0];

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mincostpath[m][n] = Math.min(mincostpath[m - 1][n], mincostpath[m][n - 1]);
            }
        }

        return mincostpath[m][n];
    }

    public int minPathDPWithBlocks(int[][] cost, int mincostpath[][], boolean blocks[][], int m, int n) {

        if (m == 0 && n == 0) return cost[m][n];

        if (m == 0) mincostpath[0][n] = cost[0][n];
        if (n == 0) mincostpath[m][0] = cost[m][0];

        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (blocks[m - 1][n] != true) {
                    x = mincostpath[m - 1][n];
                } else if (blocks[m][n - 1] != true) {
                    y = mincostpath[m][n - 1];
                }
                mincostpath[m][n] = Math.min(x, y);
            }
        }

        return mincostpath[m][n];
    }

    public int minPathWithBlocks(int[][] cost, boolean[][] blocks, int mincostpath[][], int m, int n) {

        if (m == 0 && n == 0) return cost[0][0];

        if (m == 0) mincostpath[0][n] = mincostpath[0][n - 1] + cost[0][n];
        if (n == 0) mincostpath[m][0] = mincostpath[m - 1][0] + cost[m][0];

        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
        if (blocks[m - 1][n] != true) {
            x = minPathWithBlocks(cost, blocks, mincostpath, m - 1, n);
        } else if (blocks[m][n - 1] != true) {
            y = minPathWithBlocks(cost, blocks, mincostpath, m, n - 1);
        }

        mincostpath[m][n] = Math.min(x, y) + cost[m][n];
        return mincostpath[m][n];
    }

    private ListNode removeNthFromEnd(ListNode A, int B) {

        ListNode temp = A;
        ListNode prev = A;

        if (A == null || A.next == null) return null;


        for (int i = 0; i < B; i++) {
            if (temp == null) {
                return A.next;
            }
            temp = temp.next;
        }

        // Handling trivial condition when we need to remove first node.
        if (temp == null) {
            return A.next;
        }

        while (temp.next != null) { // to reach end of loop
            temp = temp.next;
            prev = prev.next;
        }

        prev.next = prev.next.next;

        return A;

        // Bad solution -> Jugad
        /*ListNode temp =A;
        ListNode prev =A;

        if(A== null) return null;
        if(A.next == null && B == 1){
            return null;
        }

        ListNode prev1= null;
        int i;
        for (i = 0; i < B; i++) {
            if(temp==null){
                return A.next;
            }
            if(i == 0 || i == 1){
                prev1 = A;
            }else {
                prev1 = prev1.next;
            }
            temp = temp.next;
        }

        if(temp == null){
            return  A.next;
        }

        while (temp != null && temp.next != null){ // to reach end of loop
            temp = temp.next;
            prev = prev.next;
        }

        prev.next = prev.next.next;

        return A;*/

        // Solution editorial
         /* Using dummy as starting point eliminates various test cases *//*
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy, fast = dummy;
        slow.next = A;

        *//* Move fast pointer 'n' nodes ahead of slow*//*
        for(int i=0; i <= B; i++){
            if(fast == null) break;
            fast = fast.next;
        }

        *//* Move fast and slow at same pace until fast reaches end *//*
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        *//* slow points to previous node of the actual node to be deleted *//*
        slow.next = slow.next.next;

        return dummy.next;*/
    }

    public ListNode swapPairs(ListNode A) {
        ListNode head = A;

        if (A == null || A.next == null) return A;

        ListNode a = null;
        ListNode temp1 = A;
        ListNode temp2 = A.next;
        ListNode temp3 = A.next.next;

        while (temp1 != null && temp2 != null) {
            if (a != null) {
                a.next = temp2;
            } else {
                head = temp2;
            }
            temp1.next = temp3;
            temp2.next = temp1;


            a = temp1;
            temp1 = temp3;

            if (temp3 != null) {
                temp2 = temp3.next;
            }

            /*if(temp3.next!= null){
                temp3 = temp3.next.next;
            }
            * */

            if (temp2 != null) {
                temp3 = temp2.next;
            }

        }

        return head;
    }

    public ListNode reorderList(ListNode A) {

        if (A == null || A.next == null || A.next.next == null) return A;

        ListNode head, h1, h2, prev;
        head = prev = h1 = h2 = A;

        //Trying to get head of next list to be reversed.
        while (h1 != null && h2 != null) {

            prev = h1;
            h1 = h1.next;
            if (h2.next != null) {
                h2 = h2.next.next;
            } else {
                h2 = null;
            }
        }

        prev.next = null;

        h1 = revereNodes(h1);

        while (h1 != null && head != null) {
            ListNode temp1 = head.next;
            head.next = h1;
            head = temp1;

            ListNode temp2 = h1.next;
            h1.next = head;
            h1 = temp2;
        }

        return A;
    }

    private ListNode revereNodes(ListNode h1) {

        ListNode a = null;
        ListNode b = h1;
        ListNode c = h1.next;

        while (b != null) {
            b.next = a;
            a = b;
            b = c;
            if (c != null) c = c.next;
        }

        return a;
    }

    private void printNodes(ListNode h1) {
        while (h1 != null) {
            System.out.print(h1.val + " ");
            h1 = h1.next;
        }

    }

    public ListNode reorderListOld(ListNode A) {

        ListNode tempForLenght = A;

        if (A == null) return null;
        if (A.next == null) return A;

        int lengthOfList = 0;
        while (tempForLenght != null) {
            lengthOfList++;
            tempForLenght = tempForLenght.next;
        }

        int reverseStart = lengthOfList / 2;

        A = reverseBetween(A, reverseStart + 1, lengthOfList);

        ListNode b = A;


        int i = 0;
        while (i < reverseStart) {
            b = b.next;
            i++;
        }

        int x = 0;
        ListNode a = A;
        while (x < lengthOfList / 2 - 1) {
            A = A.next;
            x++;
        }
        A.next = null;

        if (lengthOfList <= 3) {
            a.next = b;
            return a;
        }

        ListNode output = a;
        boolean flag = false;

        while (b != null && a != null) {

            //Storing temporary variables for later use
            ListNode temp1 = a.next;
            ListNode temp2 = b.next;
            if (temp1 == null && temp2 != null) {
                flag = true;
            }
            // changing pointers

            a.next = b;
            if (!flag) {
                b.next = temp1;
            }

            // Moving pointers to next position
            a = temp1;
            b = temp2;

            /*if(a.next == null) {
                a.next =b;
                break;
            }*/

            /*//Storing temporary variables for later use
            ListNode temp1 = A;
            ListNode temp2 = b;

            // changing pointers
            A.next = b;
            b.next = temp1.next;

            // Moving pointers to next position
            A = temp1.next;
            b = temp2.next;
*/
            /*ListNode temp1 = A.next;
            ListNode temp2 = b.next;
            A.next = b;
            b.next = temp1;
            b = temp2;
            k++;
            A =temp1;*/
        }

        return output;
    }

    public ListNode reverseBetween(ListNode a, int m, int n) {
        ListNode node, result;
        node = a;

        if (node == null)
            return null;

        result = null;
        int i = 1;
        if (node != null) {
            result = recurseNodes(node, i, m, n);
        }
        return result;
    }

    private ListNode recurseNodes(ListNode node, int i, int m, int n) {

        ListNode res = null;
        ListNode temp = null;
        ListNode temp1 = node;

        int j = n - m;
        if (node.next != null) {

            if (i == m) {
                return temp = reverseLinkedList(node, n - m + 1);
            }

            while (node.next != null) {
                res = recurseNodes(node.next, ++i, m, n);
                node.next = res;
                if (temp != null) {
                    temp.next = node;
                    res = temp;
                    return temp;
                } else {
                    res = node;
                    return node;
                }
            }
            return res;
        } else {
            return node;
        }
    }

    private ListNode reverseLinkedList(ListNode A1, int i) {


        ListNode node, temp, prev, temp1;

        node = A1;
        temp1 = A1;

        boolean first = false;

        if (node == null)
            return null;

        prev = null;

        while (node != null && i > 0) {

            temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
            i--;
        }

        temp1.next = node;

        return prev;
    }

    static String feeOrUpfront(int n, int k, int x, int d, int[] p) {
        double totalCharge = 0;
        for (int i : p) {
            totalCharge += Math.max(Double.valueOf(k), (Double.valueOf(x) * Double.valueOf(i)) / (100));

            if (totalCharge > d) {
                return "upfront";
            }
        }
        return "fee";
    }
}
