public class Main {
    public static void main(String[] args) {
        Circle circle= new Circle("green",5);
        double area1 = circle.area();
        circle.display(area1);

        Rectangle rectangle= new Rectangle("red",4,5);
        double area2 = rectangle.area();
        rectangle.display(area2);
    }
}

class Shape{
    String color;

    Shape(String color){
        this.color=color;
    }

    double area(){
        return(0);
    }

    void display(double area){
        System.out.println("This is a shape");
    }

}

class Circle extends Shape{
    double radius;

    Circle(String color,double radius){
        super(color);
        this.radius=radius;
    }

    @Override
    double area(){
         return (3.14*radius*radius);

    }

    @Override
    void display(double area){
        System.out.println("This is a circle with a color of "+color+" and an area of "+ area);
    }

}

class Rectangle extends Shape{
    int a;
    int b;

    Rectangle(String color,int a,int b){
        super(color);
        this.a=a;
        this.b=b;
    }

    @Override
    double area(){
        return (a*b);

    }

    @Override
    void display(double area){
        System.out.println("This is a circle with a color of "+color+" and an area of "+ area);
    }

}
