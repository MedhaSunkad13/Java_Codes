// package OOPs;
public class Student {
    
        public int id;
        private int age;
        private String name;
        public int no_s;
        private String gf;

        public String getName() {
            return this.name;
        }

        public int getAge() {
            return this.age;
        }

        public void setAge(int a) {
            //Extra layer of authentication
                if(age < 100)
                   this.age = a;
                return;
        }
        
        //Default Ctor - no parameters, attr -> garbage
        //For creating ctor write class name with braces
        public Student() {
            System.out.println("Student default constructor called!");
        }
        
        //Parameterized ctor
        public Student(int id, int age, String name, int nos, String gf) {
            System.out.println("Student Parameterized ctor is called");
            this.id = id;
            this.age = age;
            this.name = name;
            this.no_s = nos;
            this.gf = gf;
        }
        
        //Copy ctor
        public Student(Student srcobj) { //srcobj -> A
            System.out.println("Student copy ctor is called");
            this.id = srcobj.id;
            this.age = srcobj.age;
            this.name = srcobj.name;
            this.no_s = srcobj.no_s;
            this.gf = srcobj.gf;
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

        // private void gfChatting() {
        //     System.out.println(name + " is chatting with gf");
        // }

        // A.age = 30; //Private variables cannot be accessed here.
        
}