import java.util.HashMap;

public class howSum {
    public static void main(String[] args) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int[] arr = howSumRecursion(300, new int[] { 7, 14 });
        System.out.println(arr);
        if (arr != null) {

            for (var each : arr) {
                System.out.println(each);
            }
            System.out.println();
        }
        int[] arr1 = howSumMemoized(300, new int[] { 7, 14 }, map);
        System.out.println(arr1);
        if (arr1 != null) {
            for (var each : arr1) {
                System.out.println(each);
            }
            System.out.println();
        }
    }

    static int[] howSumMemoized(int target, int[] arr, HashMap<Integer, int[]> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target == 0) {
            return new int[] {};
        } else if (target < 0) {
            return null;
        }
        for (int i = 0; i < arr.length; i++) {
            int reminder = target - arr[i];
            int[] result = howSumMemoized(reminder, arr, map);
            if (result != null) {
                int[] res = new int[result.length + 1];
                for (int j = 0; j < result.length; j++) {
                    res[j] = result[j];

                }
                res[res.length - 1] = arr[i];
                map.put(target, res);
                return res;
            }
        }
        map.put(target, null);
        return null;
    }

    static int[] howSumRecursion(int target, int[] arr) {
        if (target == 0) {
            return new int[] {};
        } else if (target < 0) {
            return null;
        }
        for (int i = 0; i < arr.length; i++) {
            int reminder = target - arr[i];
            int[] result = howSumRecursion(reminder, arr);
            if (result != null) {
                int[] res = new int[result.length + 1];
                for (int j = 0; j < result.length; j++) {
                    res[j] = result[j];

                }
                res[res.length - 1] = arr[i];
                return res;
            }
        }
        return null;
    }
}
