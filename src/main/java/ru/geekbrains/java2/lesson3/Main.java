package ru.geekbrains.java2.lesson3;

import java.util.*;

/**
 * Created by Home-pc on 25.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        Integer a;
        Boolean b;
        Long l;
        ArrayList<Integer> list = new ArrayList<>();
//        list.add(new String("kljhkl456"));
        list.add(new Integer("123456"));
        Integer i = list.get(0);
//        String s = (String)list.get(1);
//        System.out.println(s.isEmpty());
        List<String> list1 = new ArrayList<>(45);
        list1.add("gf");
        list1.add("gtytf");
        list1.add("g5466f");
        list1.add("gbvnmbnf");
        System.out.println(list1);
        list1.remove("gf");
        list.ensureCapacity(1000);
        list1.toArray();
        System.out.println(list1);
        System.out.println(list1.get(1));
        LinkedList<String> list2 = new LinkedList<>();
        list2.addFirst("5345");
        list2.addLast("56hrtfgh");
        list2.peekLast();//getLast()
        list2.poll();
//        list2.iterator().

        HashSet<String> hashSet  = new HashSet<>();
        hashSet.add("1234");
        hashSet.add("1234");
        hashSet.add("14");
        hashSet.contains("1234");
        System.out.println(hashSet);

        Map<String, String> map = new HashMap<>();
        map.put("1", "dsjgidfhtvnisyrtgrveiyut5ytv5t8ny5ctv");
        map.put("2", "dsjgidfhtvnisyrtgrveiyut5ytv5t8ny5ctv");
        map.put("3", "dsjgid654654vnisyrtgrveiyut5ytv5t8ny5ctv");
        System.out.println(map);
        map.put("2", "1234456");
        System.out.println(map);
        map.get("2");
        map.equals(list);

        List emptyList = Collections.EMPTY_LIST;
        System.out.println(map.keySet());
        for(String key : map.keySet()){
            System.out.println(key +" - "+ map.get(key));
        }

    }
}
