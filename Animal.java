public class Main{
    public static void main (String[] args) {
        Dog dog = new Dog("Max",3,"Labrador");
        dog.makeSound();


 //       dog.eat();
 //       dog.sleep();
 //       dog.bark();

    }
}

class Animal{
    String name;
    int age;

    Animal(String name,int age){
        this.name=name;
        this.age=age;
        System.out.println("Animal is created:");
    }

    void makeSound(){
        System.out.println("Animal make sound");
    }

    void eat() {
        System.out.println(name + " eat");
    }

    void sleep() {
        System.out.println(name + " sleep");
    }

}

class Dog extends Animal{
    String breed;

    Dog(String name,int age,String breed) {
        super(name,age);
        this.breed = breed;
        System.out.println("Dog is created:" + name);
    }

    @Override
    void makeSound(){
        super.makeSound();
        System.out.println("Dog make sound");
    }

    void bark(){
        System.out.println(name+"barked");
    }
}

