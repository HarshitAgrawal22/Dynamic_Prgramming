import java.util.ArrayList;
import java.util.HashMap;

public class bestSum {
    public static void main(String[] args) {
        for (Integer a : bestSumRecursive(7, new int[] { 5, 3, 4, 7 })) {
            System.out.println(a);
        }
        for (Integer a : bestSumMemoized(100, new int[] { 1, 2, 5, 25 }, new HashMap<Integer, ArrayList<Integer>>())) {
            System.out.println(a);
        }
        for (Integer a : bestSumRecursive(100, new int[] { 1, 2, 5, 25 })) {
            System.out.println(a);
        }

    }

    static ArrayList<Integer> bestSumRecursive(int target, int[] arr) {
        if (target == 0) {
            return new ArrayList<Integer>();
        }
        if (target < 0) {
            return null;
        }
        ArrayList<Integer> store = null;
        for (int i = 0; i < arr.length; i++) {
            int reminder = target - arr[i];
            ArrayList<Integer> result = bestSumRecursive(reminder, arr);

            if (result != null) {
                ArrayList<Integer> res = new ArrayList<>();

                for (Integer data : result) {
                    // System.out.println(data);
                    res.add(data);
                }
                res.add(arr[i]);

                if (store == null || store.size() > res.size()) {

                    store = (ArrayList<Integer>) res.clone();
                    // for (Integer integer : store) {
                    // System.out.println(integer);
                    // }
                }
            }
        }
        return store;
    }

    static ArrayList<Integer> bestSumMemoized(int target, int[] arr, HashMap<Integer, ArrayList<Integer>> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target == 0) {
            return new ArrayList<Integer>();
        }
        if (target < 0) {
            return null;
        }
        ArrayList<Integer> store = null;
        for (int i = 0; i < arr.length; i++) {
            int reminder = target - arr[i];
            ArrayList<Integer> result = bestSumMemoized(reminder, arr, map);

            if (result != null) {
                ArrayList<Integer> res = new ArrayList<>();

                for (Integer data : result) {
                    // System.out.println(data);
                    res.add(data);
                }
                res.add(arr[i]);

                if (store == null || store.size() > res.size()) {

                    store = (ArrayList<Integer>) res.clone();
                    // for (Integer integer : store) {
                    // System.out.println(integer);
                    // }
                }
            }
        }
        map.put(target, store);
        return store;
    }
}
