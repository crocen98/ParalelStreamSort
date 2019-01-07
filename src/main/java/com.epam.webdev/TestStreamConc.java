package com.epam.webdev;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestStreamConc {

    public static void main(String ... args){

    List<Integer> list =  initList(8192);
        System.out.println(list.size());
        CleaverIntComparator comparator;
    list.parallelStream().sorted(comparator = new CleaverIntComparator()).toArray();
        System.out.println(comparator.getThreadscont());
        System.out.println(comparator.getThreads());

        BinarySeatcherInteger binarySeatcher = new BinarySeatcherInteger();
        System.out.println(binarySeatcher.search(100000));

        BinarySeatcherWrapper binarySeatcherForWrapper = new BinarySeatcherWrapper();
        System.out.println(binarySeatcherForWrapper.search(100000));


    }

    private static List<Integer> initList(int size){
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i<size;++i){
            list.add(new Random().nextInt());
        }

        return list;
    }



}
