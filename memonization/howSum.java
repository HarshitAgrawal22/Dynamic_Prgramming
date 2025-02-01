import java.util.HashMap;

public class howSum {
    public static void main(String[] args) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = howSumRecursion(7, new int[] { 2, 3 });
        for (var each : arr) {
            System.out.println(each);
        }
        System.out.println();
        int[] arr1 = howSumRecursion(7, new int[] { 5, 4, 7, 3 });
        for (var each : arr1) {
            System.out.println(each);
        }
        System.out.println();
    }

    static void howSumMemoized(int target, int[] arr, HashMap<Integer, Integer> map) {

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
