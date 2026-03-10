
class Animals {

    String name;
    String species;
    int age;

    Animals(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    void speak() {
        System.out.println(name + "makes animal sound");
    }

    void eat() {
        System.out.println(name + "eats this food");
    }

    void sleep() {
        System.out.println(name + "sleeps for x hours a day");
    }

}

class dog extends Animals {

    dog(String name, String species, int age) {
        super(name, species, age);
    }

    @Override
    void speak() {
        System.out.println(name + " barks");
    }

    @Override
    void eat() {
        System.out.println(name + " eats bone");
    }

    @Override
    void sleep() {
        System.out.println(name + " sleeps for 5 hours a day");
    }

}

class cat extends Animals {

    cat(String name, String species, int age) {
        super(name, species, age);
    }

    @Override
    void speak() {
        System.out.println(name + " meows");
    }

    @Override
    void eat() {
        System.out.println(name + " eats fish");
    }

    @Override
    void sleep() {
        System.out.println(name + " sleeps for 8 hours a day");
    }

}

class bird extends Animals {

    bird(String name, String species, int age) {
        super(name, species, age);
    }

    @Override
    void speak() {
        System.out.println(name + " caws");
    }

    @Override
    void eat() {
        System.out.println(name + " eats lemon");
    }

    @Override
    void sleep() {
        System.out.println(name + " sleeps for 2 hours a day");
    }

}

public class Pet {

    public static void main(String[] args) {

        Animals dog = new dog("Rex", "dog", 3);
        Animals cat = new cat("Milo", "cat", 2);
        Animals bird = new bird("Sky", "bird", 1);

        dog.speak();
        dog.eat();
        dog.sleep();

        cat.speak();
        cat.eat();
        cat.sleep();

        bird.speak();
        bird.eat();
        bird.sleep();

    }
}
