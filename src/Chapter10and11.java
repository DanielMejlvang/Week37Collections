import java.util.*;

//Daniel Mejlvang Rasmussen, DAT19A
public class Chapter10and11 {
    //Chapter 10, Exercise 1
    static double averageVowels(ArrayList<String> al) {
        double vowels = 0;
        double characters = 0;
        for (String s: al) {
            characters += s.length();
            s = s.replaceAll("[^AEIOUaeiou]", "");
            vowels += s.length();
        }
        return vowels / characters;
    }

    //Chapter 11, Exercise 6
    static int countUnique(List<Integer> list) {
        return new HashSet<>(list).size();
    }

    //Chapter 11, Exercise 8
    static int minLength(Set<String> set) {
        if (set.isEmpty()) {
            return 0;
        }
        int shortestString = 100;
        for (String s : set) {
            if (s.length() < shortestString) {
                shortestString = s.length();
            }
        }
        return shortestString;
    }

    //Chapter 11, Exercise 10
    static void removeOddLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 != 0);
    }

    //Chapter 11, Exercise 12
    static boolean contains3(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        //count occurrences
        for (String s : list) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        //check if it has value 3 or above
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 3) {
                return true;
            }
        }
        return false;
    }

    //Chapter 11, Exercise 13
    static boolean isUnique(Map<String, String> map) {
        String key = "";
        String searchValue = "";

        for (Map.Entry<String, String> entry : map.entrySet()) {
            searchValue = entry.getValue();
            //wanted to use .remove with specific key and searchvalue
            //and then use .containsValue, but the iterator failed when doing that
            map.put(entry.getKey(), searchValue+"surelynoonehasanamewiththis");
            if (map.containsValue(searchValue)) {
                return false;
            }
        }
        return true;
    }

    //main for testing
    public static void main(String[] args) {
        //Test average vowels
        ArrayList<String> al = new ArrayList<>();
        al.add("Daniel");
        al.add("Daniel");
        al.add("Daniel");
        al.add("DanielOAIUOAOIUAOIU");
        al.add("Danielaaaa");
        System.out.println("Average vowels: " + averageVowels(al));

        //Test countUnique
        ArrayList<Integer> ial = new ArrayList<>();
        ial.add(2);
        ial.add(5);
        ial.add(8);
        ial.add(2);
        System.out.println("Count unique: " + countUnique(ial));

        //Test minlength
        Set<String> set = new HashSet<>();
        set.add("Daniel");
        set.add("DanielM");
        set.add("Test");
        set.add("Why");
        System.out.println("Min length: " + minLength(set));

        //Test removeOddLength
        removeOddLength(set);
        System.out.println("Remove odd length: " + set);

        //Test contains3
        System.out.println("Contains 3: " + contains3(al));

        //Test isUnique
        Map<String, String> map = new HashMap<>();
        map.put("Daniel", "Mejlvang");
        map.put("Peter", "Petersen");
        map.put("Kurt", "Mejlvang");
        System.out.println("Is unique: " + isUnique(map));
    }
}
