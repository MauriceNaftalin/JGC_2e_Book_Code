package org.jgcbook.chapter09.G_lambdas_and_streams;
// 11.7.0

record Point(int x, int y) {
    public double distanceFrom(Point p) {return Math.sqrt((x-p.x)^2 +(y-p.y)^2);}

}