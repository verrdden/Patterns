package com.lab111.labwork5;

import java.util.Iterator;

/**
 * Created by verrden on 05.05.16.
 */
public class Main {
    public static void main(String[] args) {
        CustomList customList = new CustomList();

        customList.add(7);
        customList.add(5);
        customList.add(9);
        customList.add(4);
        customList.add(6);
        customList.add(2);
        Iterator iterator = customList.iterator();
        System.out.println("consistent");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Iterator iterator1 = customList.sortedIterator();
        System.out.println("sorted");
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

    }
}
