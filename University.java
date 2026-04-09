public class Main {

    int add(int a, int b) {
        return a + b;
    }
    int add(int a, int b, int c){
        return a+b+c;
    }


    public static void main(String[] args) {
        University.setPassScore(580);
        System.out.println(University.passScore);

        University university=new University();
        university.establishmentYear=2014;
        university.name="Khazar University";
        university.showInfo();
        System.out.println(university.establishmentYear);



        }
    }

class University{
    static int passScore=600;
    static int numberOfMajors=234;

    String name;
    int studentCount;
    int establishmentYear;

    void showInfo(){
        System.out.println(this.name);
    }

    static void setPassScore(int newScore){
        passScore=newScore;
    }
}
