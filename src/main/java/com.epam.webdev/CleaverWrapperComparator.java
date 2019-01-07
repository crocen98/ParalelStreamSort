package com.epam.webdev;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class CleaverWrapperComparator implements Comparator<IntWrapper> {
    private Set<Thread> threads;
    public CleaverWrapperComparator(){
        threads = new HashSet<>();
    }
    public int compare(IntWrapper o1, IntWrapper o2) {
        // System.out.println(Thread.currentThread());
        threads.add(Thread.currentThread());
        return Integer.compare(o1.get(),o2.get());
    }


    public int getThreadsCount() {
        return threads.size();
    }

    public Set<Thread> getThreads() {
        return threads;
    }

}
