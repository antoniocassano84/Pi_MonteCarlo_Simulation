package com.company;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        int count = 0;
        int runs = 100000;
        BigDecimal currentEstimate = null;

        for(int i = 0; i < runs; i++) {
            Point p = new Point();
            if(p.isInsideCircle()) {
                count += 1;
                currentEstimate = new BigDecimal(4 * ( (double) count / runs));
                System.out.println("Loop " + (i+1) + " : Pi =  " + currentEstimate);
            }
        }
        System.out.println("Pi = " + currentEstimate);
    }
}
