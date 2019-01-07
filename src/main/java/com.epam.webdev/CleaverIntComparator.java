package com.epam.webdev;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class CleaverIntComparator implements Comparator<Integer> {
    private Set<Thread> threads;
    public CleaverIntComparator(){
        threads = new HashSet<>();
    }
    public int compare(Integer o1, Integer o2) {
       // System.out.println(Thread.currentThread());
        threads.add(Thread.currentThread());
        return Integer.compare(o1,o2);
    }


    public int getThreadscont() {
        return threads.size();
    }

    public Set<Thread> getThreads() {
        return threads;
    }
}
