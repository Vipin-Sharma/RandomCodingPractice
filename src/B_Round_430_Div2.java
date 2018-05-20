/**
 * Created by nitinkumarsharma on 8/18/17.
 *
 8 4
 7
 7 8 1
 -7 3 2
 0 2 1
 0 -2 2
 -3 -3 1
 0 6 2
 5 3 1
 */



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_Round_430_Div2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner();
        int r = in.nextInt();
        int d = in.nextInt();

        Integer num = in.nextInt();
        double dist;
        int x=0;
        int y=0;
        int z=0;
        int liesInside=0;

        for (int i = 0; i < num; i++) {
            x = in.nextInt();
            y = in.nextInt();
            z= in.nextInt();
            dist = Math.sqrt(x*x + y*y);
            if ((dist + z) <= r && (dist - z) >= (r-d)){
                liesInside++;
            }
        }

        System.out.println(liesInside);
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