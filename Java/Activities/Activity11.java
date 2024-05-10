package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {
        Map<Integer,String> colors = new HashMap<>();
        colors.put(1,"Orange");
        colors.put(2,"pink");
        colors.put(3,"Green");
        colors.put(4,"Yellow");
        colors.put(5,"Red");

        colors.remove(4);
        System.out.println(colors.containsValue("Green"));
        System.out.println(colors.size());
    }
}
