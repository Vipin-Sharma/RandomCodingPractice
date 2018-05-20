/**
 * Created by nitinkumarsharma on 8/18/17.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class A_Round_429_Div2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner();
        int n = in.nextInt();
        int k = in.nextInt();

        String colours = in.nextLine();

        char[] chars = colours.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();

        for (char aChar : chars) {
            if(map.containsKey(aChar)){
                if(map.get(aChar)+1 > k){
                    System.out.println("NO");
                    return;
                }
                map.put(aChar, map.get(aChar)+1);
            }else {
                map.put(aChar,1);
            }
        }

        System.out.println("YES");
    }

    static class Scanner {

        BufferedReader br;
        StringTokenizer st;

        public Scanner() throws FileNotFoundException {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {

            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

        public boolean endLine() {
            try {
                String next = br.readLine();
                while (next != null && next.trim().isEmpty()) {
                    next = br.readLine();
                }
                if (next == null) {
                    return true;
                }
                st = new StringTokenizer(next);
                return st.hasMoreTokens();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}