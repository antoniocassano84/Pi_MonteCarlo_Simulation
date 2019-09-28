package com.company;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Point.java - a simple class for a point in a 2D space.
 * @author  Antonio Cassano
 * @version 1.0
 */
public class Point {

    private BigDecimal x;  // This is the horizontal coordinate
    private BigDecimal y;  // This is the vertical coordinate

    /**
     * A simple constructor for the Point class - a point in a 2D space.
     * It sets x and y to BigDecimal object of a random number between
     * 0(inclusive) and 1(exclusive) - [0, 1)
     * using the Math.random() function.
     * @see <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Math.html#random()">Math.random() documentation</a>
     */
    public Point() {
        this.x = new BigDecimal(Math.random());
        this.y = new BigDecimal(Math.random());
    }

    /**
     * Simple getter for the x coordinate.
     * It returns a BigDecimal object with 5 decimal places
     * rounded UP.
     * @return the x coordinate as BigDecimal object
     */
    public BigDecimal getX() {
        return x.setScale(5, RoundingMode.UP);
    }

    /**
     * Simple getter for the y coordinate.
     * It returns a BigDecimal object with 5 decimal places
     * rounded UP.
     * @return the y coordinate as BigDecimal object
     */
    public BigDecimal getY() {
        return y.setScale(5, RoundingMode.UP);
    }

    /**
     * Calculates the distance ^ 2 between the point
     * and the origin of the cartesian system having
     * coordinates (X = 0; Y= 0).
     * It uses the formula: X^2 + Y^2
     * @see <a href="https://proofwiki.org/wiki/Distance_of_Point_from_Origin_in_Cartesian_Coordinates">Distance of Point from Origin in Cartesian Coordinates</a>
     * @return a BigDecimal object representing the distance between the point and the origin
     * of the cartesian system.
     */
    private BigDecimal distance() {
        MathContext mc = new MathContext(5);
        return this.x.pow(2, mc).add(this.y.pow(2, mc));
    }

    /**
     * Checks whether the point is inside a circle of radius 1
     * and center in the origin of the system (X = 0; Y = 0).
     * @return true if the point is inside the circle, false if it is outside.
     */
    public boolean isInsideCircle() {
        return this.distance().compareTo(new BigDecimal(1.0d)) == -1? true : false;
    }
}
