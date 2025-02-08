public class canConstruct {
    public static void main(String[] args) {
        System.out.println(canConstructRecursion("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }));
        System.out.println(canConstructRecursion("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }));
        System.out.println(canConstructRecursion("skateboard", new String[] { "bo", "ate", "t", "ska" }));

    }

    static boolean canConstructRecursion(String target, String[] arr) {
        if (target == "") {
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            if (target.indexOf(word) == 0) {
                final String suffix = target.substring(word.length());
                System.err.println(suffix);
                if (canConstructRecursion(suffix, arr)) {
                    return true;
                }
            }
        }
        return false;
    }

    // boolean canConstructMemoized() {

    // }
}
