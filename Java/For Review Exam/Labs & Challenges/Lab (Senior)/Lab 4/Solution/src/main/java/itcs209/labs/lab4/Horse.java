package itcs209.labs.lab4;

public class Horse {
    private String name;
    private String breed;
    private double weight;
    private double age;

    public Horse(String name, String breed, double weight, int age) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
        this.age = age;
    }

    public Horse() {
        this.name = "Not Available";
        this.breed = "Horse";
        this.weight = 33;
        this.age = 1;
    }

    public String getFirstName() {
        return this.name;
    }

    public String getKind() {
        return this.breed;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getAge() {
        return this.age;
    }

    public String Signature() {
        return this.name+" "+"("+this.breed+")";
    }

    public void setFirstName(String name) {
         this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setAge(double age) {
         this.age = age;
    }
}
