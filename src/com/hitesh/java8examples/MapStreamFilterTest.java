package com.hitesh.java8examples;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by hiteshs on 2/28/18.
 */
public class MapStreamFilterTest {

    public static void main(String[] args) {

        Map<String,Integer> score= new HashMap<>();
        score.put("rohit",101);
        score.put("dhawan",24);
        score.put("kohli",20);
        score.put("rahane",56);
        score.put("dhoni",78);
        score.put("bhuvi",1);
        score.put("pandya",0);
        score.put("kuldeep",0);
        score.put("bumrah",18);

        //show the scoreboard by iterating over each entry
        score.forEach((k,v)-> System.out.println(k +" Scored: "+v));

        //who scored the duck
        score.entrySet().stream()
                .filter(x->x.getValue()==0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                    .forEach((k,v)-> System.out.println(k +" Scored Duck :"+v));

        //who all scored half century
        score.entrySet().stream()
                .filter(x->x.getValue()>=50&& x.getValue()<100)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue))
                .forEach((k,v)->System.out.println(k+" Scored Half century"));

        //who all scored half century
        score.entrySet().stream()
                .filter(x->x.getValue()>100)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue))
                .forEach((k,v)->System.out.println(k+" Scored century"));

        //who scored highest
        Optional x=score.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));
        System.out.println("highest score :"+ x);


        //who score the minimum
        Optional y=score.entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue));
        System.out.println("highest score :"+ y);

        //show the score in descending order
        score.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1, LinkedHashMap::new))
                .forEach((k,v)->System.out.println(k+" Scored "+ v));
        //show the score in ascending order
        score.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1, LinkedHashMap::new))
                .forEach((k,v)->System.out.println(k+" Scored "+ v));

        //total score of the team
        System.out.println("Total score of india: "+score.values().stream().mapToInt(Integer::intValue).sum());

        //

    }

}
