import java.util.HashMap;

public class canSum {
    public static void main(String[] args) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        System.out.println(targetSumMemoized(new int[] { 9, 8 }, 37, map));

        // System.out.println(targetSum(new int[] { 5, 3, 4, 7 }, 7, map));
        // System.out.println(targetSum(new int[] { 2, 4, 8 }, 7, map));
        System.out.println(targetSumMemoized(new int[] { 7, 14 }, 300, map));
    }

    static boolean targetSumMemoized(int[] arr, int target, HashMap<Integer, Boolean> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target == 0) {
            return true;

        }
        if (target < 0) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            int reminder = target - arr[i];
            boolean result = targetSumMemoized(arr, reminder, map);
            map.put(reminder, result);
            if (result) {

                return result;
            }
        }

        return false;
    }
}
