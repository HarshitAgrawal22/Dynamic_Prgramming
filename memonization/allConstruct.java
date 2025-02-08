import java.util.ArrayList;

public class allConstruct {
    public static void main(String[] args) {
        // for (String each : firstConstructRecursive("purple", new String[] { "p",
        // "purp", "ur", "le", "purpl" })) {
        // System.out.println(each);
        // }
        for (ArrayList<String> each : allConstructRecurssive("purple",
                new String[] { "p", "purp", "ur", "le", "purpl" })) {
            System.out.println(each);
            for (String string : each) {

            }
            System.err.println();
        }
    }

    static String[] firstConstructRecursive(String target, String[] bank) {
        if (target == "") {
            return new String[] {};
        }
        for (int i = 0; i < bank.length; i++) {
            String word = bank[i];
            if (target.indexOf(word) == 0) {
                String sufString = target.substring(word.length());
                String[] temp = firstConstructRecursive(sufString, bank);
                if (temp != null) {
                    String[] arr = new String[temp.length + 1];
                    for (int j = 0; j < temp.length; j++) {
                        arr[j] = temp[j];
                    }
                    arr[arr.length - 1] = word;
                    return arr;
                }
            }
        }
        return null;
    }

    static ArrayList<ArrayList<String>> allConstructRecurssive(String target, String[] words) {
        if (target == "") {
            ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
            data.add(new ArrayList<String>());
            return data;
        }

        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        for (String word : words) {
            if (target.indexOf(word) == 0) {

                ArrayList<ArrayList<String>> ways = allConstructRecurssive(target.substring(word.length()), words);

                for (ArrayList<String> way : ways) {
                    // System.err.println(way);
                    way.add(word);

                }

                for (ArrayList<String> each : ways) {

                    result.add(each);
                }

            }
        }
        return result;
    }

}
