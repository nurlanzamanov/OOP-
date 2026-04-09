public class Document implements  Printable , Saveable{
    String fileName;

    Document(String fileName){
        this.fileName=fileName;
    }

    @Override
    public void print(){
        System.out.println(fileName);
    }

    @Override
    public void save(){
        this.fileName=fileName;
    }

}
