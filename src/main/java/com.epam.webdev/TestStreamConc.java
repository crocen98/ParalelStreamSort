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

        System.out.println("**********************************");
        List<Integer> list2 =  initList(8193);
        System.out.println(list2.size());
        list2.parallelStream().sorted(comparator = new CleaverIntComparator()).toArray();
        System.out.println(comparator.getThreadscont());
        System.out.println(comparator.getThreads());
        System.out.println("**********************************");

        BinarySeatcherInteger binarySearcher = new BinarySeatcherInteger();
        System.out.println(binarySearcher.search(100000));

        BinarySeatcherWrapper binarySearcherForWrapper = new BinarySeatcherWrapper();
        System.out.println(binarySearcherForWrapper.search(100000));


    }

    private static List<Integer> initList(int size){
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<size;++i){
            list.add(new Random().nextInt());
        }

        return list;
    }



}
