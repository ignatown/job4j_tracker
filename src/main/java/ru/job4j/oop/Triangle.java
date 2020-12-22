package ru.job4j.oop;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    private Triangle(Point ap, Point bp, Point cd){
        this.first = ap;
        this.second = bp;
        this.third = cd;
    }

    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }


    public boolean exist(double ab, double ac, double bc) {
        return (ab + ac > bc && ac + bc > ab && bc + ab > ac);
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        double p = period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
}