package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("Avi");
        myList.add("Arika");
        myList.add("Rohan");
        myList.add("Vibha");
        myList.add("Prabhat");


        System.out.println(myList);
        System.out.println(myList.get(2));
        System.out.println(myList.size());
        System.out.println(myList.remove(4));
        System.out.println(myList.contains("Vibha"));
        myList.remove("Prabhat");
        System.out.println(myList.size());


    }


}
