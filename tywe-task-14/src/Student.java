import java.util.Arrays;

public class Student {
    private String name;
    private int age;


    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

//    public String toString(){
//        return this.name;
//    }

    public static void main(String[] args) {
        Object oj = new Student("Tomas", 22);
        Object rt = new Student("Jason", 34);
        Object[] asd = new Object[] {oj, rt};
        System.out.println(Arrays.toString(asd));
    }

}
