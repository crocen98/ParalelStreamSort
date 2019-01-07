package com.epam.webdev;

public class IntWrapper {
    private Integer integer;
    public IntWrapper(int integer){
        this.integer = integer;
    }

    public Integer get() {
        return integer;
    }

    public void set(Integer integer) {
        this.integer = integer;
    }
}
