import java.util.*;

class anagram {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    static List<List<String>> Anagrams(String[] string_list) {

        ArrayList<List<String>> anagrams = new ArrayList<>();
        String l[] = new String[string_list.length];
        for (int i = 0; i < l.length; i++) {
            char c[] = string_list[i].toCharArray();
            Arrays.sort(c);
            l[i] = new String(c);
        }
        HashMap<String, ArrayList<String>> hash = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < l.length; i++) {
            // check if LinkedList exists
            ArrayList<String> list = hash.get(l[i]);
            // anagram present
            if (list != null) {
                list.add(string_list[i]);
            } else {
                ArrayList<String> x = new ArrayList<String>();
                x.add(string_list[i]);
                hash.put(l[i], x);
            }
        }
        for (Map.Entry element : hash.entrySet()) {
            ArrayList<String> value = (ArrayList<String>) element.getValue();
            anagrams.add(value);
        }
        return anagrams;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String list[] = { "act", "god", "cat", "dog", "tac" };
        List<List<String>> l = anagram.Anagrams(list);
        for (List<String> i : l) {
                System.out.println(Arrays.toString(i.toArray()));
        }
    }
}