package com.epam.webdev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BinarySeatcherWrapper {
    public  int search(int startSize){
        List<IntWrapper>arr;
        //System.out.println(list.size());
        CleaverWrapperComparator comparator;
        int left = 0;
        int right = startSize-1;
        while (true){
            int mid = left + (right - left) / 2;
            arr =  Arrays.asList(initArr(mid));
            arr.parallelStream().sorted(comparator = new CleaverWrapperComparator()).toArray();

            if(comparator.getThreadscont()==1){
                arr =  Arrays.asList(initArr(mid + 1));
                arr.parallelStream().sorted(comparator = new CleaverWrapperComparator()).toArray();
                if(comparator.getThreadscont()!=1){
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid;
            }
        }
    }


    private static IntWrapper[] initArr(int size){
        IntWrapper[] arr = new IntWrapper[size];
        Random random = new Random();
        for(int i = 0; i<size;++i){
            IntWrapper wrapper = new IntWrapper(random.nextInt());
            arr[i]=wrapper;
        }
        return arr;
    }
}

