package by.it.maksimova.jd01_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List <String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list);
        list.remove("three");
        System.out.println(list);
        System.out.println(list.get(1));
        list.addAll(Collections.singleton("two, three, six"));
        System.out.println(list);
            }
}
