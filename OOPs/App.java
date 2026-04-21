
public class App{
    public static void main(String[] args) {
// 		System.out.println("Hello World");

        //Default Ctor
        // Student A = new Student();
        // A.id = 1;
        // A.age = 14;
        // A.name = "Goli";
        // A.no_s = 5;
        
        // System.out.println(A.id);
        // System.out.println(A.age);
        // System.out.println(A.name);
        // System.out.println(A.no_s);
        
        // A.bunk();
        // A.study();
        // A.sleep();
        
        //Parameterized Ctor
        Student A = new Student(2, 13, "Tapu", 3);
        
        // System.out.println(A.id);
        // System.out.println(A.age);
        // System.out.println(A.name);
        // System.out.println(A.no_s);
        
        // A.bunk();
        // A.study();
        // A.sleep();
        
        //Copy Ctor
        //Similar to:
        // int a = 10;
        // int b = a;
        Student B = new Student(A);
        
        System.out.println(B.id);
        System.out.println(B.age);
        System.out.println(B.name);
        System.out.println(B.no_s);
        
        B.sleep();
        B.study();
	}
}