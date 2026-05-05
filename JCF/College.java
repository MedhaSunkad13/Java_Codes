package JCF;

public class College implements Comparable<College> {

    public int age;
    public String name;
    public int weight;

    public College(int age, String name, int weight) {
        this.age = age;
        this.name = name;
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(College that) {
        //return this.weight - that.weight; //Sorting by weight (Ascending Order)
        //return that.weight - this.weight; //Sorting by weight (Descending order)
        //Sorting on the basis of name
        return this.name.compareTo(that.name);
    }

    @Override
    public String toString() {
        return "College{age=" + age + ", name=" + name + ", weight=" + weight + "}";
    }
}