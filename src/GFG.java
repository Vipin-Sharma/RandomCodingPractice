import java.util.HashMap;
import java.util.Scanner;


public class GFG {

    //https://practice.geeksforgeeks.org/problems/longest-path-in-a-matrix/0
    //https://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/
    public static void main(String[] args) {

    }

    //https://practice.geeksforgeeks.org/problems/special-matrix/0
    public static void main_mazeWays(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfTestCases = in.nextInt();
        for (int i = 0; i < numOfTestCases; i++) {
            int rows = in.nextInt();
            int cols = in.nextInt();
            int blocks = in.nextInt();
            int[][] array = new int[rows][cols];
            for (int j = 0; j < blocks; j++) {
                int row = in.nextInt();
                int col = in.nextInt();
                array[row-1][col-1] = -1;
            }
            System.out.println(mazeWays(array, 0, 0));
        }
    }


    // Recursive version of solution, DP version was easy and run through solution given
    private static int mazeWays(int[][] array, int i, int j) {

        if(i >= array.length || j >= array[0].length ) return 0;

        if(i == array.length - 1 && j == array[0].length -1 ) return 1;

        int x=0;
        if( i+1 <= array.length -1 && array[i+1][j] != -1){
            x = mazeWays(array, i+1, j);
        }

        int y=0;
        if( j+1 <= array[0].length -1  && array[i][j+1] != -1){
            y = mazeWays(array, i, j+1);
        }

        return (x+y) % 1000000007;
    }

    //https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
    public static void main_findLongestUniqueCharsSubstring(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfTestCases = in.nextInt();
        for (int i = 0; i < numOfTestCases; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            char[] chars = in.next().toCharArray();
            map.put(chars[0], 1);
            System.out.println(findLongestUniqueCharsSubstring(chars, 1, 1, map));
        }
    }

    // recursive working fine, DP pending
    private static int findLongestUniqueCharsSubstring(char[] chars, int index, int prevLength, HashMap<Character, Integer> map) {

        // When index has already covered entire array
        if(index >= chars.length) return prevLength;

        int x=0; int y=0;

        //if (chars[index] == chars[index-1]){
        if(map.containsKey(chars[index])){
            map.clear();
            map.put(chars[index], 1);
            x = findLongestUniqueCharsSubstring(chars, index + 1, 1, map);
        }else {
            map.put(chars[index], 1);
            x = findLongestUniqueCharsSubstring(chars, index + 1, 1 + prevLength, map);
        }

        map.clear();
        y = findLongestUniqueCharsSubstring(chars, index + 1, 0, map);

        //return Math.max(prevLength, x);
        return x>y ? (x>prevLength ? x : prevLength) : y;
    }

    public static void main_hopWsysDP(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfTestCases = in.nextInt();
        for (int i = 0; i < numOfTestCases; i++) {
            System.out.println(hopWsysDP(in.nextInt()));
        }
    }

    private static long hopWsysDP(int n) {
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 2;

        long[] h = new long[n+1];
        h[0] = 1;
        h[1] = 1;
        h[2] = 2;

        int i=3;

        while (i<=n){
            h[i] = h[i-1] + h[i-2] + h[i-3];
            i++;
        }
        return h[n];
    }

    // Recursive version
    private static int hopWsys(int n) {
        if(n == 0) return 1;
        if(n < 0) return 0;

        int x = hopWsys(n-1);
        int y = hopWsys(n-2);
        int z = hopWsys(n-3);

        return x+y+z;
    }

    public static void mainMergeLists(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);

        Node d = new Node(15);
        Node e = new Node(17);

        a.next = b;
        b.next = c;

        d.next = e;

        new GFG().printNodes(new GFG().MergeLists(a, d));
    }

    // Recursive working solution
    Node MergeLists(Node headA, Node headB) {

        if (headA == null) return headB;
        if (headB == null) return headA;

        Node head = null;

        if (headA.data < headB.data) {
            head = headA;
            head.next = MergeLists(headA.next, headB);
        } else {
            head = headB;
            head.next = MergeLists(headA, headB.next);
        }

        return head;
    }

    private void printNodes(Node h1) {
        while (h1 != null) {
            System.out.print(h1.data + " ");
            h1 = h1.next;
        }
    }

    //Minimum sum difference partition problem
    /*
Given an array, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.

Input:
The first line contains an integer 'T' denoting the total number of test cases.
In each test cases, the first line contains an integer 'N' denoting the size of array.
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
In each seperate line print minimum absolute difference.

Constraints:
1<=T<=30
1<=N<=50
1<=A[I]<=50

Example Input:
2
4
1 6 5 11
4
36 7 46 40

Output :
1
23
     */

    public static void main_minPartitionDP(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfTestCases = in.nextInt();
        for (int i = 0; i < numOfTestCases; i++) {
            int sizeOfArray = in.nextInt();
            int[] s1 = new int[sizeOfArray];
            int sumOfS1 = 0;
            for (int j = 0; j < sizeOfArray; j++) {
                s1[j] = in.nextInt();
                sumOfS1 += s1[j];
            }
            System.out.println(minPartition(s1, 0, sumOfS1));
        }

    }

    // Question: how do I use 2d matrix to solve this problem, How do i get 2d matrix intuition from recursive solution, why I am not thinking in right direction
    // My thought process:
    // in 2d matrix, columns with 0 to sum of s1, row from 0 to all elements of s1. I am trying to fill it using knapsack and minimum number of coin problems.
    private static int minPartitionDP(int[] s1, int total) {
        int a[][] = new int[s1.length + 1][total + 1];

        return a[s1.length][total];
    }

    // Recursive working
    private static int minPartition(int[] s1, int index, int difference) {
        if (index >= s1.length) return difference;

        //Not adding element to other partition (S2)
        int x = minPartition(s1, index + 1, difference);

        // Here we are adding element to other partition (S2)
        // difference - s1[index] --> Sum of remaining S1 array(Partition)
        // Since we are adding s1[index] to s2 now overall difference should be reduce s1[index] 2 times,
        // one because it was subtracted from S1 sum and other because it is added in S2.
        int y = minPartition(s1, index + 1, Math.abs((difference - s1[index]) - s1[index]));

        return x < y ? x : y;
    }

    //Driver function for printShortedCommonSuperSequence
    public static void main1(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String a = in.next();
            String b = in.next();
            printShortedCommonSuperSequence(a, b);
        }

    }

    // For edit distance
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            int length1 = in.nextInt();
            int l2 = in.nextInt();
            String s1 = in.next();
            String s2 = in.next();
            System.out.println(editDistanceDP(s1, s2));
        }
    }

    /*
2
7 6
sitting kitten
30 1
gkbbipzzrzucxamludfykgruowzgio o
     */

/*
    You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item, In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).


Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
Each test case consists of four lines. The first line consists of N the number of items.
The second line consists of W, the maximum capacity of the knapsack.
In the next  line are N space separated positive integers denoting the values of the N items
and in the fourth line are N space separated positive integers denoting the weights of the corresponding items.


Output:

Print the maximum possible value you can get with the given conditions that you can obtain for each test case in a new line.


Constraints:
1≤T≤100
1≤N≤100
1≤W≤100
1≤wt[i]≤100
1≤v[i]≤100

Example:

Input:
1
3
4
1 2 3
4 5 1
Output:
3
*/

    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOftests = in.nextInt();
        for (int i = 0; i < numberOftests; i++) {
            int numberOfItems = in.nextInt();
            int[] value = new int[numberOfItems];
            int[] weight = new int[numberOfItems];

            int maxCapicity = in.nextInt();

            for (int j = 0; j < numberOfItems; j++) {
                value[j] = in.nextInt();
            }
            for (int j = 0; j < numberOfItems; j++) {
                weight[j] = in.nextInt();
            }
            System.out.println(knapsackDP(value, weight, numberOfItems, maxCapicity));
        }
    }


    /*
Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is V and N,V is the value of cents and N is the number of coins.
The second line of each test case contains N input C[i],value of available coins.

Output:
Print the minimum number of coins to make the change, if not possible print -1.

Constraints:
1 ≤ T ≤ 100
1 ≤ V ≤ 10000
1 ≤ N ≤ 50
1 ≤ C[i] ≤ 100

Example:
Input
1
7 2
2 1

Output
4
     */

    public static void main_mincoinDP(String... args) {
        Scanner in = new Scanner(System.in);
        int numberOfTests = in.nextInt();

        for (int i = 0; i < numberOfTests; i++) {
            int total = in.nextInt();
            int numberOFCoins = in.nextInt();
            int c[] = new int[numberOFCoins];
            for (int j = 0; j < numberOFCoins; j++) {
                c[j] = in.nextInt();
            }
            //System.out.println(mincoin(c,total,0));
            System.out.println(mincoinDP(c, total));
        }
    }


    // Working solution
    public static int mincoinDP(int[] c, int total) {
        int[][] a = new int[c.length + 1][total + 1];

        for (int i = 0; i <= c.length; i++) {
            a[i][0] = 0;
        }
        for (int j = 1; j <= total; j++) {
            a[0][j] = Integer.MAX_VALUE - total;
        }

        for (int i = 1; i <= c.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (c[i - 1] > j) {
                    //a[i][j] = Integer.MAX_VALUE - total;
                    a[i][j] = a[i-1][j];
                } else {
                    a[i][j] = Math.min(a[i - 1][j], 1 + a[i][j - c[i - 1]]);
                }
            }
        }

        return a[c.length][total] == Integer.MAX_VALUE - total ? -1 : a[c.length][total];
    }


    public static void main_mincoin(String[] args) {
        int[] array = new int[] {31, 90, 8, 36};
        System.out.println(mincoin(array, 4759, 0));
    }

    //working recursive solution for mincoin
    public static int mincoin(int[] c, int total, int i) {

        if (total == 0) return 0;
        if (i >= c.length) return Integer.MAX_VALUE-total;


        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;

        if (total - c[i] >= 0) {
            x = 1 + mincoin(c, total - c[i], i);
        }
        y = mincoin(c, total, i + 1);

        return Math.min(x, y);
    }

    public static int knapsackDP(int[] value, int[] weight, int numberOfItems, int maxCapicity) {
        int[][] a = new int[numberOfItems + 1][maxCapicity + 1];

        for (int i = 0; i <= numberOfItems; i++) {
            a[i][0] = 0;
        }
        for (int i = 0; i <= maxCapicity; i++) {
            a[0][i] = 0;
        }

        for (int i = 1; i <= numberOfItems; i++) {
            for (int j = 1; j <= maxCapicity; j++) {
                int x = 0, y = 0;
                x = a[i - 1][j];                         // when we dont use ith element
                if (j - weight[i - 1] >= 0) {
                    y = value[i - 1] + a[i - 1][j - weight[i - 1]]; // when we use ith element
                }

                a[i][j] = Math.max(x, y);
            }

        }

        return a[numberOfItems][maxCapicity];
    }

    // solution completed
    public static int editDistanceDP(String s1, String s2) {
        int[][] a = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            a[i][0] = i;
        }
        for (int j = 0; j <= s2.length(); j++) {
            a[0][j] = j;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    a[i][j] = a[i - 1][j - 1];
                } else {
                    int x = a[i - 1][j - 1];
                    int y = a[i - 1][j];
                    int z = a[i][j - 1];

                    a[i][j] = 1 + (x > y ? (y > z ? z : y) : (x > z ? z : x));
                }
            }
        }

        return a[s1.length()][s2.length()];
    }

    // solution completed edit distance recursive
    public static int editDist(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) return 0;
        if (s1.length() == 0) return s2.length();

        if (s1.charAt(0) == s2.charAt(0)) {
            return editDist(s1.substring(1, s1.length()), s2.substring(1, s2.length()));
        } else {
            int x = editDist(s1.substring(1, s1.length()), s2);  // Insert char to s2, now first char of S2 and S1 becomes same so remove first char and call method again. Since we are adding and removing from s2, its same string for next call as well.
            int y = editDist(s1.substring(1, s1.length()), s2.substring(1, s2.length()));  // update
            int z = editDist(s1, s2.substring(1, s2.length()));  // delete

            return 1 + (x < y ? (x < z ? x : z) : (y < z ? y : z));
        }
    }


    private static void printShortedCommonSuperSequence(String first, String second) {

        int m = first.length();
        int n = second.length();
        int[][] scs = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            scs[0][i] = i;
        }
        for (int i = 0; i <= n; i++) {
            scs[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    scs[i][j] = 1 + scs[i - 1][j - 1];
                } else {
                    scs[i][j] = 1 + Math.min(scs[i - 1][j], scs[i][j - 1]);
                }
            }

        }

        System.out.println(scs[m][n]);
    }
}