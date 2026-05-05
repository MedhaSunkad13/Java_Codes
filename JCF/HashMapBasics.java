package JCF;

import java.util.*;

public class HashMapBasics {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        //Insertion
        map.put("in", "India");
        map.put("in", "India2"); //Value India will be replaced by India2
        map.put("us", "United States");
        map.put("en", "England");
        map.put("es", "Spain");

        System.out.println("Printing HashMap: " + map);

        //Insertion
        Map<String, String> mp = new HashMap<>();

        mp.put("br", "Brazil");

        System.out.println("Before: " + mp);

        //putAll()
        mp.putAll(map);
        System.out.println(mp);

        //Deletion
        mp.remove("en");
        System.out.println(mp);

        //Size
        System.out.println(mp.size());

        //putIfAbsent()
        mp.putIfAbsent("uk", "United Kingdom");
        mp.putIfAbsent("in", "India3");

        //get()
        System.out.println(mp.get("br"));

        //Clear
        // mp.clear();
        System.out.println(mp);

        //getOrDefault()
        System.out.println(mp.getOrDefault("uk", "NONE"));

        //containsKey()
        System.out.println(mp.containsKey("in"));

        //containsValue()
        System.out.println(mp.containsValue("Britain"));

        //Replace
        System.out.println(mp);
        mp.replace("in", "Indonesia");
        System.out.println(mp);

        //keySet()
        System.out.println(mp.keySet());

        //Values
        System.out.println(mp.values());

        //entrySet()
        System.out.println(mp.entrySet());

        //Loop on the map
        for(Map.Entry<String, String> e : mp.entrySet()) {
            System.out.print(e.getKey() + ":" + e.getValue() + " ");
        }
        System.out.println();

        //EntrySet
        Set<Map.Entry<String, String>> entrySet = mp.entrySet();
        System.out.println("Printing Entries: " + entrySet);
    }
}