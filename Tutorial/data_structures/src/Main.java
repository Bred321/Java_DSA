import java.util.*;


public class Main {
    public static void main(String[] args) {
        //
        int[] x = {99, 5 ,6, 3 ,2 , 1};
        Arrays.sort(x, 1, 4);
        for(int i: x){
            System.out.print(i + ", ");
        }
        // Typical set implementation (add, contains, remove, size)
        System.out.println("-\n-Hash Set--");
        Set<Integer> t = new HashSet<Integer>();
        t.add(5);
        t.add(5);
        t.add(5);
        t.add(7);
        t.add(9);
        t.add(-8);
        t.remove(-8);
        boolean has_5 = t.contains(5);
        System.out.println(t);
        System.out.println(has_5);
        System.out.println(t.size());

        // A set with an order
        System.out.println("\n--Tree Set--");
        Set<Integer> t2 = new TreeSet<Integer>();
        t2.add(5);
        t2.add(5);
        t2.add(5);
        t2.add(7);
        t2.add(9);
        t2.add(-8);
        System.out.println(t2);

        // ArrayList
        System.out.println("\n--ArrayList--");
        ArrayList<Integer> t3 = new ArrayList<Integer>();
        t3.add(1);
        t3.add(2);
        System.out.println(t3.get(0));
        t3.set(1, 25);
        System.out.println(t3);
        System.out.println(t3.subList(1, 2));

        // HashMap
        System.out.println("\n--Hash Map--");
        Map m = new HashMap();
        m.put("Tim", 5);
        m.put("Joe", "x");
        m.put(11, 999);
        System.out.println(m);

        // TreeMap
        System.out.println("\n--Tree Map--");
        Map m2 = new TreeMap();
        m2.put("Tim", 5);
        m2.put("Joe", "x");
        m2.put("a", "b");
        m2.containsValue("b");
        m2.containsKey("Jack");
        m2.get("Tim");
        m2.clear();
        m2.isEmpty();
        System.out.println(m2);

        // Count characters
        Map<Character, Integer> count_char = new HashMap<>();
        String in_str = "hello world";
        for (char c: in_str.toCharArray()){
            if (!count_char.containsKey(c) && c != ' ') {
                count_char.put(c, 1);
            } else if (c != ' ') {
                count_char.put(c ,count_char.get(c) + 1);
            }
        }
        System.out.println(count_char);
    }
}