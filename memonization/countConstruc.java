import java.util.HashMap;

public class countConstruc {
    public static void main(String[] args) {
        System.out.println(countConstructRecursive("purple", new String[] { "purp", "p", "ur", "le", "purpl" },
                new HashMap<String, Integer>()));
        System.out.println(countConstructRecursive("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] { "e", "ee", "eeef", "eeee", "eeeee", "eeeeee" }, new HashMap<String, Integer>()));

        System.out.println(
                countConstructRecursive("enterapotentpot", new String[] { "a", "p", "ent", "enter", "ot", "o", "t" },
                        new HashMap<String, Integer>()));
    }

    static int countConstructRecursive(String target, String[] wordBank, HashMap<String, Integer> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target == "") {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < wordBank.length; i++) {
            if (target.indexOf(wordBank[i]) == 0) {
                count += countConstructRecursive(target.substring(wordBank[i].length()), wordBank, map);
            }
        }
        map.put(target, count);
        return count;
    }
}
