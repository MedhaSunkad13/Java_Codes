// package OOPs;
public class Student {
    
        public int id;
        public int age;
        public String name;
        public int no_s;
        
        //Default Ctor - no parameters, attr -> garbage
        //For creating ctor write class name with braces
        public Student() {
            System.out.println("Student default constructor called!");
        }
        
        //Parameterized ctor
        public Student(int id, int age, String name, int nos) {
            System.out.println("Student Parameterized ctor is called");
            this.id = id;
            this.age = age;
            this.name = name;
            this.no_s = nos;
        }
        
        //Copy ctor
        public Student(Student srcobj) { //srcobj -> A
            System.out.println("Student copy ctor is called");
            this.id = srcobj.id;
            this.age = srcobj.age;
            this.name = srcobj.name;
            this.no_s = srcobj.no_s;
        }
        
        
        //Methods or behaviours
        
        public void study() {
            System.out.println(name + " is studying");
        }
        
        public void sleep() {
            System.out.println(name + " is sleeping");
        }
        
        public void bunk() {
            System.out.println(name + " bunks");
        }
}