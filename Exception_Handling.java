import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Library{
    static int count = 0;
    List<String> existingBook = new ArrayList<>( Arrays.asList(
            "Harry Potter","Hobbit","1984"
    ));

    public void getBook(String name){
        if (!existingBook.contains(name)){

        }
    }
    public void borrowing(String name){
        if (count>3){
            super("Enough books");
        }
    }

    public void countUp(){
        count+=1;
    }
}


class User{
    String name;

    User(String name){
        this.name=name;
    }
}

class MyException1 extends Exception{
    MyException1(String msg){
        super(msg);
    }
}

class MyException2 extends Exception{
}
