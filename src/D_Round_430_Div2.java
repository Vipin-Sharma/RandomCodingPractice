/**
 * Created by nitinkumarsharma on 8/18/17.
 *
 2 2
 1 3
 1
 3
 */



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D_Round_430_Div2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int minInt=0;

        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            for (int j = 0; j < n; j++) {
                a[j] = a[j]^x;
            }
            Arrays.sort(a);


            for (int j = 0; j < a.length; j++) {
                if(j==0){
                    if(a[j]==0){
                        minInt =1;
                    }else {
                        minInt =0;
                    }
                }else {
                    if(a[j]==minInt){
                        minInt++;
                    }else {
                        System.out.println(minInt);
                        break;
                    }
                }
            }

        }

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