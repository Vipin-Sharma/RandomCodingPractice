/**
 * Created by nitinkumarsharma on 9/01/17.
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_Round_431_Div2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner();
        int n = in.nextInt();


        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, in.nextInt());
        }

        HashMap<Float, Integer> mmap = new HashMap<>();

        float m = 0;
        boolean commonFound = false;
        float mcommon = 0;
        float c1 = 0;

        for (int i = 2; i <= n; i++) {
            m = (float) (map.get(i) - map.get(1)) / (i - 1);
            c1 = map.get(i) - m * i;
            if (mmap.containsKey(m)) {
                if (Math.abs(mcommon - 0) < .00000000001) {
                    mcommon = m;
                } else if (Math.abs(mcommon - m) > .00000000001) {
                    System.out.println("No");
                    return;
                }/* Redundant else
                else {
                    mcommon = m;
                }*/

                map.remove(i);
                map.remove(mmap.get(m));
                commonFound = true;
            } else {
                mmap.put(m, i);
            }
        }
        /*if (!commonFound) {
            System.out.println("No");
            return;
        } else {
            map.remove(1);
        }*/
        map.remove(1);

        if (map.size() == 0) {
            System.out.println("No");
            return;
        }

        float msame = 0;
        float tempm = 0;
        int first = -1;

        for (Integer integer : map.keySet()) {
            if (first == -1) {
                first = integer;
            } else {
                if (Math.abs(msame - 0) < .00000000001) {
                    tempm = (float) (map.get(integer) - map.get(first)) / (integer - first);
                    msame = tempm;
                } else {
                    tempm = (float) (map.get(integer) - map.get(first)) / (integer - first);
                    if (Math.abs(tempm - msame) > .00000000001) {
                        System.out.println("No");
                        return;
                    }
                }

            }
        }
        if (msame != mcommon & n!=3) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
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