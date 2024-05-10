package activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<String>();
        hs.add("Pink");
        hs.add("Yellow");
        hs.add("Green");
        hs.add("Red");
        hs.add("Blue");
        hs.add("white");

        System.out.println(hs.size());
        System.out.println(hs.remove("Pink"));
        System.out.println(hs.remove("Orange"));
        System.out.println(hs.contains("Blue"));
        System.out.println(hs);
    }




}
