import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by nitinkumarsharma on 11/19/16.
 */
public class Solution_InterviewBit {
    public static void main(String[] args) {
        /*System.out.println(new Solution().minDistance("Anshuman","Antihuman"));*/
        /*System.out.println(new Solution().minDistance("aac", "abac"));*/
        /*System.out.println(new Solution().numTrees(7));*/
        //2 6 6 7 8 4

        ArrayList<ArrayList<Integer>> inp = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(1);
        //arr.add(1);
        inp.add(arr);

        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(0);
        arr1.add(1);
        arr1.add(1);
        //arr1.add(1);
        inp.add(arr1);


        //System.out.println(new Solution().maximalRectangle(inp));

        ArrayList<String> lst = new ArrayList<>();

        String[] starr =  {"aabababaa", "aaaabaa", "ababaabaa", "aaaa", "b", "aaaaba", "a", "aaba", "bbaaaaaab", "bbb", "aabbaaaaba", "baa", "aabbaba", "abbabb", "bbaaab", "bbbbabbaab", "abbaabbb", "babaa", "b", "bbaaa", "bab", "abaaaaaa", "bbbba", "baababab", "abbaa", "bbaaaaa", "aaaabbbbba"};

        for (String s : starr) {
            lst.add(s);
        }

        /*lst.add("interview");
        lst.add("my");
        lst.add("trainer");*/

        /*lst.add("a");
        lst.add("aaba");
        lst.add("ab");
*/
        //System.out.println(new Solution().wordBreak("aaaabaababaaaabaabbabbbbbabaabbbbabbbabaabbabaaaaaabaabbabbbaabaababaabbaaabaababbaabbbaabaaaaabbbbaaaaabaababbbababbabbaabbbbabababaababaaaababbbaaaaaaabbbbaabbbbabbbabbbaaabbaaaaabbbabaaaabbababbbbaababaabaababbbbababbbaaaabbbbaabbbaaaabaababbbaaaaaabbbabbaaabaabaabaaaababbbabbbabbbaabbabaaabaaabbababaabbabaaaabbbbbbabbababaaabbababbabbaaaabbabbbababbbbaabaaabbbaababababaaaaaaaabababaabbabaaabbabaaaaaabbbbbbabaaabbaaaaaaaabbbbabbaaabaabbabbbbbbbbbbbbbbabbbababbbbaabaaabaababbaaabbbbaaabbbbbaabababbaabbabbaaabaababbbbbaaaaabbbabaabaaaabaaaaababbabbababbbbbbaaababbbbbbbabbaabbabaaabbbaabbabaaaabaababb",
        //      lst));
        //System.out.println(new Solution().wordBreak("myinterviewtrainer", lst));
        //System.out.println(new Solution().wordBreak("aabaab", lst));

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(100);
        arr2.add(500);
        arr2.add(100);
        arr2.add(10);
        //arr2.add(10);
        inp.add(arr2);

        //System.out.println(new Solution().minimumTotal(inp));
        System.out.println(new Solution_InterviewBit().maxcoin(arr2));
    }


    public int maxcoin(ArrayList<Integer> a) {
        int result =0;
        int[][] arrFirst = new int[a.size()][a.size()];
        int[][] arrSecond = new int[a.size()][a.size()];

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j <= a.size() - 1 - i; j++) {
                if(i==0){
                    arrFirst[j][j] = a.get(j);
                    arrSecond[j][j] = 0;
                }else if(i==1){
                    arrFirst[j][j+i] = Math.max(a.get(j), a.get(j+i));
                    arrSecond[j][j+i] = Math.min(a.get(j), a.get(j + i));
                } else {
                    if(a.get(j) + arrSecond[j + 1][j + i] > a.get(i + j) + arrSecond[j][j + i - 1]) {
                        //arrFirst[j][j + i] = Math.max(a.get(j) + arrSecond[j + 1][j + i], a.get(i + j) + arrSecond[j][j + i - 1]);
                        arrFirst[j][j + i] = a.get(j) + arrSecond[j + 1][j + i];
                        arrSecond[j][j+i] = arrFirst[j+1][j+i];
                    }else {
                        arrFirst[j][j + i] = a.get(i + j) + arrSecond[j][j + i - 1];
                        arrSecond[j][j+i] = arrFirst[j][j+i-1];
                    }
                }
            }
        }

        return arrFirst[0][a.size()-1];
    }

    public int wordBreak(String s, Set<String> wordDict) {
        int[] pos = new int[s.length()+1];

        Arrays.fill(pos, -1);

        pos[0]=0;

        for(int i=0; i<s.length(); i++){
            if(pos[i]!=-1){
                for(int j=i+1; j<=s.length(); j++){
                    String sub = s.substring(i, j);
                    if(wordDict.contains(sub)){
                        pos[j]=i;
                    }
                }
            }
        }

        return pos[s.length()];
    }

    public int wordBreak(String a, ArrayList<String> b) {
        int result =0;
        HashMap<String, String> map = new HashMap<>();
        for(String s: b){
            map.put(s,s);
        }
        int[][] arr = new int[a.length()][a.length()];

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < a.length()-i; j++) {
                if(map.containsKey(a.substring(j,j+i+1))){
                    arr[j][j+i] = 1;
                }else {
                    for (int k = 0; k < i; k++) {
                        if(arr[j][j+k] == 1 && arr[j+k+1][j+i]==1){
                            arr[j][j+i] = 1;
                            break;
                        }else {
                            arr[j][j+i] = 0;
                        }
                    }
                }
            }
        }

        return arr[0][a.length()-1];
    }

    public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
        int maxarea = -1;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<=a.size()-1;i++) {
            ArrayList<Integer> templist = new ArrayList<>();
            for (int j =0 ; j <=a.get(i).size() - 1; j++) {
                if(list.size()==0){
                    templist.add(j, a.get(i).get(j));
                }
                else if(a.get(i).get(j) != 0) {
                    templist.add(j, a.get(i).get(j) + list.get(j));
                }else {
                    templist.add(j, 0);
                }
            }

            //list = templist;
            Iterator<Integer> itrl = list.iterator();
            while (itrl.hasNext()){
                itrl.next();
                itrl.remove();
            }

            for (Integer integer : templist) {
                list.add(integer);
            }

            Iterator<Integer> itr = templist.iterator();
            while (itr.hasNext()){
                itr.next();
                itr.remove();
            }

            int area = largestRectangleArea(list);
            if(area>maxarea){
                maxarea = area;
            }
        }

        return maxarea;
    }


    /*public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
        int[][] arrrow = new int[a.size()][a.get(0).size()];
        int[][] arrcol = new int[a.size()][a.get(0).size()];
        int[][] arrmaxcol = new int[a.size()][a.get(0).size()];
        int[][] arrmaxrow = new int[a.size()][a.get(0).size()];
        int maxarea =0;


        for(int i=a.size()-1;i>=0;i--){
            for(int j=a.get(i).size()-1; j>=0;j--){

                if(i==a.size()-1 && j==a.get(i).size()-1){
                    if(a.get(i).get(j)==1){
                        arrcol[i][j] = 1;
                        arrmaxcol[i][j] = 1;
                        arrrow[i][j] = 1;
                        arrmaxrow[i][j] = 1;
                    }else{
                        arrcol[i][j] = 0;
                        arrmaxcol[i][j] = 0;
                        arrrow[i][j] = 0;
                        arrmaxrow[i][j] = 0;
                    }
                }
                else if(i==a.size()-1){
                    if(a.get(i).get(j)==1){
                        arrrow[i][j] = arrrow[i][j+1] +1;
                        arrmaxrow[i][j] = 1;
                        arrcol[i][j] = 1;
                        arrmaxcol[i][j] = 1;
                    }else{
                        arrrow[i][j] = 0;
                        arrmaxrow[i][j] = 0;
                        arrcol[i][j] = 0;
                        arrmaxcol[i][j] = 0;
                    }
                }
                else if(j==a.get(i).size()-1){
                    if(a.get(i).get(j) == 1){
                        arrcol[i][j] = arrcol[i+1][j]+1;
                        arrmaxcol[i][j] = 1;
                        arrrow[i][j] = 1;
                        arrmaxrow[i][j] = 1;
                    }else{
                        arrcol[i][j] = 0;
                        arrmaxcol[i][j] = 0;
                        arrrow[i][j] = 0;
                        arrmaxrow[i][j] = 0;
                    }
                }else{
                    if(a.get(i).get(j)==1){
                        arrrow[i][j] = arrrow[i][j+1] +1;
                        if(a.get(i+1).get(j+1) != 0 && a.get(i+1).get(j) !=0 && a.get(i).get(j+1) !=0) {
                            arrmaxrow[i][j] = arrmaxrow[i + 1][j + 1] < arrrow[i][j + 1]
                                    ? arrmaxrow[i + 1][j + 1] + 1
                                    : arrrow[i][j + 1] + 1;
                        }else {
                            //arrmaxrow[i][j] = arrrow[i][j];
                            arrmaxrow[i][j] = 1;
                        }
                        arrcol[i][j] = arrcol[i+1][j]+1;
                        if(a.get(i+1).get(j+1) != 0 && a.get(i+1).get(j) !=0 && a.get(i).get(j+1) !=0) {
                            arrmaxcol[i][j] = arrmaxcol[i + 1][j + 1] < arrcol[i + 1][j]
                                    ? arrmaxcol[i + 1][j + 1] + 1
                                    : arrcol[i + 1][j] + 1;
                        }else {
                            //arrmaxcol[i][j] = arrcol[i][j];
                            arrmaxcol[i][j] = 1;
                        }
                    }else{
                        arrrow[i][j] = 0;
                        arrmaxrow[i][j] = 0;
                        arrcol[i][j] = 0;
                        arrmaxcol[i][j] = 0;
                    }
                }


                int row = arrrow[i][j];
                int col = arrcol[i][j];
                int max = Math.max(row,col);
                if (Math.max(max, arrmaxcol[i][j] * arrmaxrow[i][j]) > maxarea){
                    maxarea = Math.max(max, arrmaxcol[i][j] * arrmaxrow[i][j]);
                }

            }
        }
        return maxarea;
    }*/

    public int largestRectangleArea(ArrayList<Integer> a) {
        int result = 0;
        if(a.size()==1){
            return a.get(0);
        }else if (a.size()==0){
            return result;
        }

        Stack<Integer> stack = new Stack<>();
        int maxArea = -1;

        for (int i = 0; i < a.size();) {
            if(stack.size()==0){
                stack.push(i);
                i++;
            }
            else if(stack.size()>0 && a.get(i)>= a.get(stack.peek())){
                stack.push(i);
                i++;
            }else {
                int h = a.get(stack.pop());
                int w = stack.empty() ? i : i -stack.peek()-1;
                int area = h*w;
                if (area>maxArea) maxArea=area;
            }
        }


        while (stack.size()>0){
            int h = a.get(stack.pop());
            int w = stack.empty() ? a.size() : a.size() -stack.peek()-1;
            int area = h*w;
            if (area>maxArea) maxArea=area;
        }

        return maxArea;
    }

    public int maxcoinold(ArrayList<Integer> a) {
        int result =0;
        int[][] arr = new int[a.size()][a.size()];

        result = mv(a, 0, a.size() - 1, arr);

        return result;
    }

    private HashMap<String,Integer> hashMap = new HashMap<>();

    private int mv(ArrayList<Integer> a, int i, int j, int[][] arr) {

        if(hashMap.containsKey(String.valueOf(i) + String.valueOf(j))) return hashMap.get(String.valueOf(i) + String.valueOf(j));
        if(i==j) return a.get(i);
        else if(j==i+1) return Math.max(a.get(i), a.get(j));
        else {
            arr[i+1][j] = Math.max(a.get(i)+ Math.min(mv(a,i+2,j,arr), mv(a,i+1,j-1,arr)), a.get(j)+ Math.min(mv(a,i+1,j-1,arr), mv(a,i,j-2,arr)));
            arr[i][j-1] = Math.max(a.get(i)+ Math.min(mv(a,i+2,j,arr), mv(a,i+1,j-1,arr)), a.get(j)+ Math.min(mv(a,i+1,j-1,arr), mv(a,i,j-2,arr)));
        }

        hashMap.put(String.valueOf(i) + String.valueOf(j), Math.max(arr[i+1][j], arr[i][j-1]));
        return hashMap.get(String.valueOf(i) + String.valueOf(j));
    }

    /*public int maxcoin(ArrayList<Integer> a) {
        return maxcoinrec(a, true);
    }

    public int maxcoinrec(ArrayList<Integer> a, boolean turn) {
        if(a.size() ==0) return 0;
        int result = 0;

        if(a.get(0)>=a.get(a.size()-1)){
            if(turn) {
                result = a.get(0);
            }
            a.remove(0);
        }else{
            if(turn){
                result=a.get(a.size()-1);
            }
            a.remove(a.size()-1);
        }
        result += maxcoinrec(a, !turn);

        return result;
    }*/



    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int ms = 0;
        int[] arr = new int[a.size()];

        for (ArrayList<Integer> integers : a) {
            int[] temp = new int[a.size()];
            for (int i = 0; i < integers.size(); i++) {
                if (integers.size() == 1) {
                    temp[0] = integers.get(0);
                    continue;
                }
                if (i >= 1 && i < integers.size() - 1) {
                    temp[i] = integers.get(i) + min(arr[i - 1], arr[i]);
                } else if (i == 0) {
                    temp[i] = integers.get(i) + arr[0];
                } else if (i == integers.size() - 1) {
                    temp[i] = integers.get(i) + arr[i - 1];
                }
            }
            arr = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) ms = arr[i];
            else {
                if (arr[i] < ms) {
                    ms = arr[i];
                }
            }
        }

        return ms;
    }

    private Integer min(int i, int i1) {
        return i < i1 ? i : i1;
    }


    HashMap<Integer, Integer> map = new HashMap<>();

    public int numTrees(int a) {
        if (a == 1) return 1;
        if (a == 0) return 1;

        if (this.map.containsKey(new Integer(a))) {
            return this.map.get(new Integer(a));
        }
        int res = 0;
        for (int i = 1; i <= a; i++) {
            int left = i - 1;
            int right = a - i;
            res += numTrees(left) * numTrees(right);
        }
        this.map.put(new Integer(a), new Integer(res));
        return res;
    }


    /*public int numTrees(int a) {
        if (a == 0) return 0;
        if (a == 1) return 1;
        if (this.map.containsKey(new Integer(a))) {
            return this.map.get(new Integer(a));
        }
        int res = 0;
        for (int i = 1; i <= a; i++) {
            int root = i;
            int left = i - 1;
            int right = a - i;
            int lr = 0;
            lr = numTrees(left);
            int rr = 0;
            rr = numTrees(right);
            if (lr > 1) res += lr;
            if (rr > 1) res += rr;

            if (lr <= 1 & rr <= 1) res++;
        }
        this.map.put(new Integer(a), new Integer(res));
        return res;
    }*/

    public int minDistance(String a, String b) {

        char[] arra = a.toCharArray();
        char[] arrb = b.toCharArray();

        int[][] dp = new int[arra.length + 1][arrb.length + 1];

        for (int i = 0; i <= arra.length; i++) {
            for (int j = 0; j <= arrb.length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (arra[i - 1] == arrb[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                }

            }
        }
        return dp[arra.length][arrb.length];
    }

    private int min(int x, int y, int z) {
        if (x < y && x < z) return x;
        if (y < x && y < z) return y;
        else return z;
    }
}
