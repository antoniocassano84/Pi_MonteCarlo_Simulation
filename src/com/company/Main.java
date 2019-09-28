package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Locale;

/**
 * Main.java - the entry point of this application.
 * @author  Antonio Cassano
 * @version 1.0
 */
public class Main {

    /**
     * Execution starts here
     */
    public static void main(String[] args) {

        Instant start = Instant.now();  // record the time of the start execution

        int count = 0;  // this var holds the number of points inside the circle
        int runs = 1_000_000_000;  // declares the number of points to be generated
        BigDecimal currentEstimate = null;  // holds the current pi estimate

        // formatting long integers as 1,234,567 with commas
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);

        for(int i = 0; i < runs; i++) {  // loops through 0 and runs-1
            Point p = new Point();  // creates a new Point object with random coordinates
            if(p.isInsideCircle()) {  // checks whether the point is inside the circle
                count += 1;  // point is inside then increment the count variable by 1

                // calculates the estimateas 4 times count divided by runs
                currentEstimate = new BigDecimal(4 * ( (double) count / runs));
                // round up the display 5 decimal places
                currentEstimate = currentEstimate.setScale(5, RoundingMode.UP);

                // printing out current pi estimate
                System.out.println("Loop " + numberFormat.format(i+1) +
                        " | X = " + p.getX() + " | Y = " + p.getY() +
                        " | In Circle = " + numberFormat.format(count) +
                        " (out of " + numberFormat.format(runs) + ")" +
                        " | Pi =  " + currentEstimate.toString());
            }
        }
        // printing out final pi estimate
        System.out.println("Estimate of Pi after " + numberFormat.format(runs) +
                " runs = " + currentEstimate.toString());

        Instant end = Instant.now();  // record the time of the end execution
        Duration timeElapsed = Duration.between(start, end);  // calculates the delta time
        System.out.println("Time taken : " + timeElapsed.toMinutes() + " mins");
        /*
         * Loop 1,000,000,000 | X = 0.18088 | Y = 0.35895
         * In Circle = 785,404,529 (out of 1,000,000,000) | Pi =  3.14162
         * Estimate of Pi after 1,000,000,000 runs = 3.14162
         * Time taken : 280 mins - 4h 40mins
         */
    }
}
