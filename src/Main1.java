/*

The famous knapsack problem. You are packing for a vacation on the sea side and you are going to carry only one bag
with capacity S (1 <= S <= 2000). You also have N (1<= N <= 2000) items that you might want to take with you to the sea side.
Unfortunately you can not fit all of them in the knapsack so you will have to choose.
For each item you are given its size and its value. You want to maximize the total value of all the items you are going to bring.
What is this maximum total value?

        Input

        On the first line you are given S and N. N lines follow with two integers on each line describing one of your items.
        The first number is the size of the item and the next is the value of the item.

        Output

        You should output a single integer on one like - the total maximum value from the best choice of items for your trip.

        Example

Input:
4 5
1 8
2 4
2 5
2 3
3 0

1 1
4 1

50 3
10 60
20 100
30 120

5 3
1 6
2 10
3 12

        Output:
        13*/

import java.util.*;
import java.lang.*;
import java.util.Scanner;

class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = 100;
        Runnable runnable = () -> {
            System.out.println("Hello");
        };
        Thread [] t = new Thread[x];

        for ( int i = 0; i < x; i++ ) {
            t[ i ].start();
            //???
        }

        ArrayList<Integer> capArr = new ArrayList<>();
        ArrayList<Integer> valueArr = new ArrayList<>();


        int totalCapacity = scanner.nextInt();
        int numOfRows = scanner.nextInt();

        for (int i = 0; i < numOfRows; i++) {
            capArr.add(scanner.nextInt());
            valueArr.add(scanner.nextInt());
        }
        
        //new Main1().solveKnapsack(totalCapacity, numOfRows, capArr, valueArr);
        
    }

    private void solveKnapsack(int totalCapacity, int numOfRows, ArrayList<Integer> capArr, ArrayList<Integer> valueArr) {

        int maxValue=0;

        int[][] T = new int[numOfRows][totalCapacity+1];

        for (int i = 0; i < numOfRows; i++) {
            T[i][0] =0;
        }

        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j <= totalCapacity; j++) {
                if( j < capArr.get(i)){
                    if(i>0){
                        T[i][j] = T[i-1][j];
                    }else {
                        T[i][j] = 0;
                    }

                } else {
                    if (i>0) {
                        T[i][j] = Math.max(valueArr.get(i) + T[i - 1][j - capArr.get(i)], T[i - 1][j]);
                    }else {
                        T[i][j] = valueArr.get(i);
                    }
                }

                /*if(maxValue<T[i][j]){
                    maxValue = T[i][j];
                }*/
            }
        }
        /*System.out.println(maxValue);*/
        System.out.println(T[numOfRows-1][totalCapacity]);
    }
}