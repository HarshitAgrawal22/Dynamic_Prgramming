import java.util.HashMap;

public class canConstruct {
    public static void main(String[] args) {
        System.out.println(canConstructRecursion("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }));
        System.out.println(canConstructRecursion("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }));
        System.out.println(canConstructRecursion("skateboard", new String[] { "bo", "ate", "t", "ska" }));

        System.out.println(canConstructMemoized("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] { "e", "ee", "eeef", "eeee", "eeeee", "eeeeee" }, new HashMap<String, Boolean>()));
    }

    static boolean canConstructRecursion(String target, String[] arr) {
        if (target == "") {
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            if (target.indexOf(word) == 0) {
                final String suffix = target.substring(word.length());
                if (canConstructRecursion(suffix, arr)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean canConstructMemoized(String target, String[] arr, HashMap<String, Boolean> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target == "") {
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            if (target.indexOf(word) == 0) {
                final String suffix = target.substring(word.length());
                if (canConstructMemoized(suffix, arr, map)) {
                    map.put(target, true);
                    return true;
                }
            }
        }
        map.put(target, false);
        return false;
    }
}
