package com.epam.webdev;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinarySeatcherInteger {

    public  int search(int startSize){
        List<Integer> list;
        //System.out.println(list.size());
        CleaverIntComparator comparator;
        int left = 0;
        int right = startSize-1;
        while (true){
            int mid = left + (right - left) / 2;
            list =  initList(mid);
            list.parallelStream().sorted(comparator = new CleaverIntComparator()).toArray();

            if(comparator.getThreadscont()==1){
                list =  initList(mid+1);
                list.parallelStream().sorted(comparator = new CleaverIntComparator()).toArray();
                if(comparator.getThreadscont()!=1){
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid;
            }
        }
    }


    private static List<Integer> initList(int size){
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i<size;++i){
            list.add(new Random().nextInt());
        }

        return list;
    }
}
