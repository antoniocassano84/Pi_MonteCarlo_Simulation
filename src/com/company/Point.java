package com.company;

public class Point {

    private double x;
    private double y;

    public Point() {
        this.x = Math.random();
        this.y = Math.random();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private double distance() {
        return (Math.pow(this.x,2) + Math.pow(this.y,2));
    }

    public boolean isInsideCircle() {
        return this.distance() <= 1.0d? true : false;
    }
}
