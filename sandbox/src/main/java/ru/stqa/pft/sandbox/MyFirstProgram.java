package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

        Point p1 ,p2;
        p1 = new Point(1.0, 2.0);
        p2 = new Point(4,6);
        System.out.println("Расстояние между двумя точками = " + distance(p1,p2));

        System.out.println("Расстояние между двумя точками = " + p1.findDistance(p2));

    }

    public static double distance(Point p1,Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}
