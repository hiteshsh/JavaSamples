package com.hitesh.java8examples;

import java.util.*;

/**
 * Created by hiteshs on 3/1/18.
 */
public class ListStreamFilterTest {

    public static void main(String[] args) {
        List<Integer> overs=  new LinkedList();
        overs.add(0);
        overs.add(1);
        overs.add(4);
        overs.add(3);
        overs.add(6);

        //sort the over asending
        overs.stream().sorted().forEach(x->System.out.println(x));
        overs.stream().sorted(Comparator.comparingInt(Integer::intValue)).forEach(x->System.out.println(x));

        // sort the over descending
        overs.stream().sorted(Comparator.reverseOrder()).forEach(x->System.out.println(x));

        //find max
        Optional max=overs.stream().max(Comparator.comparingInt(Integer::intValue));
        System.out.println("Max: "+max.toString());

        //find max different way
        //overs.stream().


    }
}
