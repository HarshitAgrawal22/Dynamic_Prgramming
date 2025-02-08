public class countConstruc {
    public static void main(String[] args) {
        System.out.println(countConstructRecursive("purple", new String[] { "purp", "p", "ur", "le", "purpl" }));

        System.out.println(
                countConstructRecursive("enterapotentpot", new String[] { "a", "p", "ent", "enter", "ot", "o", "t" }));
    }

    static int countConstructRecursive(String target, String[] wordBank) {
        if (target == "") {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < wordBank.length; i++) {
            if (target.indexOf(wordBank[i]) == 0) {
                count += countConstructRecursive(target.substring(wordBank[i].length()), wordBank);
            }
        }
        return count;
    }
}
