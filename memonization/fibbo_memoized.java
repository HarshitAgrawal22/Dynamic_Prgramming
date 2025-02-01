import java.util.HashMap;

class fibbo_memoized {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        System.out.println(fib(hs, 40));
        // for (Integer i : hs.keySet()) {
        // System.out.println(i);
        // }
    }

    public static Integer fib(HashMap<Integer, Integer> hs, int n) {
        if (hs.containsKey(n)) {
            return hs.get(n);
        }
        if (n <= 2) {
            return 1;

        } else {

            int temp = fib(hs, n - 1) + fib(hs, n - 2);
            // System.out.println(temp);
            hs.put(n, temp);
            return temp;
        }
    }
}